package pieces;

import javafx.scene.paint.Color;
import tiles.Board;
import tiles.Tile;

public class King extends Piece {

	private boolean hasMoved = false;
	
	public King(Color c) {

		super(c);

	}

	@Override
	public void showMove(int row, int col) {
		int n;
		int y;

		for (int i = 1; i <= 4; i++) {

			if (i%2 == 0) {

				//Up & down = columns

				n = (i % 4 == 0) ? 1 : -1;

				y = n*-1;

				if (
						!(row+n >= 0) ||
						!(row+n < Board.allTiles.size()) ||
						!(col+y >= 0) ||
						!(col+y < Board.allTiles.size())) {
					continue;
				}

				Tile tileToCheck = Board.allTiles.get(row+n).get(col+y);

				if (!tileToCheck.hasPiece()) {

					tileToCheck.moveMark();

				}else if (tileToCheck.hasPiece()) {

					if (tileToCheck.getPieceColor() != this.getColor()) {

						tileToCheck.moveMark();

					}

					continue;

				}

			}

			if(i%2 != 0) {

				//Right & Left = row

				n  = (i % 3 == 0) ? 1 : -1;

				if (
						!(row+n >= 0) ||
						!(row+n < Board.allTiles.size()) ||
						!(col+n >= 0) ||
						!(col+n < Board.allTiles.size())) {
					continue;
				}

				Tile tileToCheck = Board.allTiles.get(row+n).get(col+n);

				if (!tileToCheck.hasPiece()) {

					tileToCheck.moveMark();

				}else if (tileToCheck.hasPiece()) {

					if (tileToCheck.getPieceColor() != this.getColor()) {

						tileToCheck.moveMark();

					}

					continue;

				}
			}

		}
		for (int i = 1; i <= 4; i++) {

			if (i%2 == 0) {

				//Up & down = columns

				n = (i % 4 == 0) ? 1 : -1;

				if (!(col+n >= 0) || !(col+n < Board.allTiles.get(row).size())) {
					continue;
				}

				Tile tileToCheck = Board.allTiles.get(row).get(col+n);

				if (!tileToCheck.hasPiece()) {

					tileToCheck.moveMark();

				}else if (tileToCheck.hasPiece()) {

					if (tileToCheck.getPieceColor() != this.getColor()) {

						tileToCheck.moveMark();

					}

					continue;

				}
			}

			if(i%2 != 0) {

				//Right & Left = row

				n  = (i % 3 == 0) ? 1 : -1;

				if (!(row+n >= 0) || !(row+n < Board.allTiles.size())) {
					continue;
				}

				Tile tileToCheck = Board.allTiles.get(row+n).get(col);

				if (!tileToCheck.hasPiece()) {

					tileToCheck.moveMark();

				}else if (tileToCheck.hasPiece()) {

					if (tileToCheck.getPieceColor() != this.getColor()) {

						tileToCheck.moveMark();

					}

					continue;

				}
			}
		}
	}

	@Override
	public void move() {
		
		hasMoved = true;
		
	}


}