package pieces;

import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import tiles.Board;
import tiles.Tile;

public abstract class Piece extends Group implements Moveable{

	private Color color;
	
	private boolean hasMoved = false;
	
	public Piece(Color c) {
		color = c;
		String COLOR = "WHITE";
		if (c == Color.BLACK) {
			COLOR = "BLACK";
		}

		Image img = new Image("images/" + COLOR + "_" + this.getClass().getSimpleName().toUpperCase() + ".png");
		ImageView iv = new ImageView(img);
		iv.setFitWidth(Tile.SIZE);
		iv.setFitHeight(Tile.SIZE);
		this.getChildren().add(iv);

	}

	public Color getColor() {
		return color;
	}
	
	public boolean hasMoved() {
		
		return hasMoved;
		
	}
	
	public void diagonalMove(int row, int col) {
		
		int n;
		int y;
		
		for (int i = 1; i <= 4; i++) {

			if (i%2 == 0) {

				//Up & down = columns

				int x = (i % 4 == 0) ? 1 : -1;
				
				y = x*-1;
				n = x;
				
				while(true) {
					
					if (
							!(row+n >= 0) ||
							!(row+n < Board.allTiles.size()) ||
							!(col+y >= 0) ||
							!(col+y < Board.allTiles.size())) {
						break;
					}

					Tile tileToCheck = Board.allTiles.get(row+n).get(col+y);

					if (!controlTile(tileToCheck)) {
						break;
					}

					n += x;
					y += x*-1;

				}

			}

			if(i%2 != 0) {

				//Right & Left = row

				n = 0;

				int x = (i % 3 == 0) ? 1 : -1;

				n = x;

				while(true) {

					if (
							!(row+n >= 0) ||
							!(row+n < Board.allTiles.size()) ||
							!(col+n >= 0) ||
							!(col+n < Board.allTiles.size())) {
						break;
					}

					Tile tileToCheck = Board.allTiles.get(row+n).get(col+n);

					if (!controlTile(tileToCheck)) {
						break;
					}

					n += x;

				}

			}

		}
		
	}
	
	public void straightMove(int row, int col) {
		
		int n;

		for (int i = 1; i <= 4; i++) {

			if (i%2 == 0) {

				//Up & down = columns

				int x = (i % 4 == 0) ? 1 : -1;

				n = x;

				while(true) {

					if (!(col+n >= 0) || !(col+n < Board.allTiles.get(row).size())) {
						break;
					}

					Tile tileToCheck = Board.allTiles.get(row).get(col+n);

					if (!controlTile(tileToCheck)) {
						break;
					}

					n += x;

				}

			}

			if(i%2 != 0) {

				//Right & Left = row

				n = 0;

				int x = (i % 3 == 0) ? 1 : -1;

				n = x;

				while(true) {

					if (!(row+n >= 0) || !(row+n < Board.allTiles.size())) {
						break;
					}

					Tile tileToCheck = Board.allTiles.get(row+n).get(col);

					if (!controlTile(tileToCheck)) {
						break;
					}

					n += x;

				}

			}

		}
	}

	public boolean controlTile(Tile tileToCheck) {
		
		if (!tileToCheck.hasPiece()) {

			tileToCheck.moveMark();

		}else if (tileToCheck.hasPiece()) {
			
			if (tileToCheck.getPieceColor() != this.getColor()) {
			
				tileToCheck.moveMark();
				
				
			}
			
			return false;
			
		}
		
		return true;
		
	}
	
}