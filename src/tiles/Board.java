package tiles;

import java.util.ArrayList;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import pieces.*;

public class Board extends Group{

	public static ArrayList<ArrayList<Tile>> allTiles = new ArrayList<ArrayList<Tile>>();
	private static int turn = 0;

	public static Tile whiteKing;
	public static Tile blackKing;
	public static Piece checkPiece;
	public static Tile checkTile;

	public Board() {

		for (int rows = 0; rows < 8; rows++) {

			allTiles.add(new ArrayList<Tile>());

			for (int cols = 0; cols < 8; cols++) {

				Color background = Color.LIGHTGRAY;

				if( (rows + cols) % 2 != 0) {
					background = Color.DARKGRAY;
				}

				Tile t = new Tile(background);
				t.setTranslateY(rows * Tile.SIZE);
				t.setTranslateX(cols * Tile.SIZE);
				this.getChildren().add(t);

				allTiles.get(rows).add(t);

				Color pieceColor;

				if (rows < 4) {

					pieceColor = Color.BLACK;

					if(rows == 1){
						t.addPiece(new Pawn(pieceColor));
					}

					if (rows == 0) {

						if (cols == 0 || cols == 7) {
							t.addPiece(new Rook(pieceColor));
						}else if(cols == 1 || cols == 6) {
							t.addPiece(new Knight(pieceColor));
						}else if(cols == 2 || cols == 5) {
							t.addPiece(new Bishop(pieceColor));
						}else if(cols == 3) {
							t.addPiece(new Queen(pieceColor));
						}else if(cols == 4) {
							t.addPiece(new King(pieceColor));
							blackKing = t;
						}

					}

				}else {

					pieceColor = Color.WHITE;

					if(rows == 6){
						t.addPiece(new Pawn(pieceColor));
					}

					if (rows == 7) {

						if (cols == 0 || cols == 7) {
							t.addPiece(new Rook(pieceColor));
						}else if(cols == 1 || cols == 6) {
							t.addPiece(new Knight(pieceColor));
						}else if(cols == 2 || cols == 5) {
							t.addPiece(new Bishop(pieceColor));
						}else if(cols == 3) {
							t.addPiece(new Queen(pieceColor));
						}else if(cols == 4) {
							t.addPiece(new King(pieceColor));
							whiteKing = t;
						}
					}
				}
			}
		}
	}

	public void end(String winner) {

		Text endText = new Text(winner);
		endText.setLayoutY(Tile.SIZE*4.25);
		endText.setFont(new Font(100));
		endText.setFill(Color.WHITE);
		endText.setLayoutX(Tile.SIZE*4-(endText.getLayoutBounds().getWidth()/2));


		Rectangle bkg = new Rectangle(
				Tile.SIZE,
				Tile.SIZE*3.25,
				Tile.SIZE*6,
				Tile.SIZE*1.5
				);

		bkg.setFill(Color.rgb(0, 0, 0,  0.7));
		this.getChildren().add(bkg);
		this.getChildren().add(endText);
	}

	public static void changeTurn() {

		turn++;

	}

	public static int getTurn() {

		return turn;

	}

}