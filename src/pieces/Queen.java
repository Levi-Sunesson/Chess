package pieces;

import javafx.scene.paint.Color;
import tiles.Board;
import tiles.Tile;

public class Queen extends Piece {

	public Queen(Color c) {

		super(c);

	}

	@Override
	public void showMove(int row, int col) {
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

					if (!tileToCheck.hasPiece()) {

						tileToCheck.moveMark();

					}else if (tileToCheck.hasPiece()) {

						if (tileToCheck.getPieceColor() != this.getColor()) {

							tileToCheck.moveMark();
							break;

						}

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

					if (!tileToCheck.hasPiece()) {

						tileToCheck.moveMark();

					}else if (tileToCheck.hasPiece()) {

						if (tileToCheck.getPieceColor() != this.getColor()) {

							tileToCheck.moveMark();
							break;

						}

					}

					n += x;

				}

			}

		}

		for (int i = 1; i <= 4; i++) {

			if (i%2 == 0) {

				//Up & down = columns

				n = 0;

				int x = (i % 4 == 0) ? 1 : -1;

				n = x;

				while(true) {

					if (!(col+n >= 0) || !(col+n < Board.allTiles.get(row).size())) {
						break;
					}

					Tile tileToCheck = Board.allTiles.get(row).get(col+n);

					if (!tileToCheck.hasPiece()) {

						tileToCheck.moveMark();

					}else if (tileToCheck.hasPiece()) {

						if (tileToCheck.getPieceColor() != this.getColor()) {

							tileToCheck.moveMark();
							break;

						}

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

					if (!tileToCheck.hasPiece()) {

						tileToCheck.moveMark();

					}else if (tileToCheck.hasPiece()) {

						if (tileToCheck.getPieceColor() != this.getColor()) {

							tileToCheck.moveMark();
							break;

						}

					}

					n += x;

				}

			}

		}

	}

	@Override
	public void move() {
		// TODO Auto-generated method stub

	}

}