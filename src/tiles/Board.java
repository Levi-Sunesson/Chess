package tiles;

import java.util.ArrayList;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import pieces.*;

public class Board extends Group{

	public static ArrayList<ArrayList<Tile>> allTiles = new ArrayList<ArrayList<Tile>>();
	private static int turn = 0;
	
	public static Tile whiteKing;
	public static Tile blackKing;
	
	public Board() {

		this.setTranslateX(5);
		this.setTranslateY(5);

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

				if(rows == 1){
					t.addPiece(new Pawn(Color.BLACK));
				}
				if(rows == 6){
					t.addPiece(new Pawn(Color.WHITE));
				}
				if (rows == 0) {

					Color pieceColor = Color.BLACK;

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
				}else if (rows == 7) {

					Color pieceColor = Color.WHITE;

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

	public void Check() {
		
		
		
	}
	
	public static void changeTurn() {
		
		turn++;
		
	}
	
	public static int getTurn() {
		
		return turn;
		
	}
	
}