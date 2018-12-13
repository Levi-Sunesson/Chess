package pieces;

import javafx.scene.paint.Color;
import tiles.Board;
import tiles.Tile;

public class King extends Piece {

	public boolean hasMoved = false;

	public boolean checked = false;
	public boolean hasBeenChecked = false;
	
	public King(Color c) {

		super(c);

	}

	@Override
	public void showMove(int row, int col) {

		Tile tileToCheck;
		
		if (!hasMoved) {

			Tile.rockadSetup(row);
			
		}

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

				tileToCheck = Board.allTiles.get(row+n).get(col+y);

				if (!controlTile(tileToCheck)) {

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

				tileToCheck = Board.allTiles.get(row+n).get(col+n);

				if (!controlTile(tileToCheck)) {

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

				tileToCheck = Board.allTiles.get(row).get(col+n);

				if (!controlTile(tileToCheck)) {

					continue;

				}
			}

			if(i%2 != 0) {

				//Right & Left = row

				n  = (i % 3 == 0) ? 1 : -1;

				if (!(row+n >= 0) || !(row+n < Board.allTiles.size())) {
					continue;
				}

				tileToCheck = Board.allTiles.get(row+n).get(col);

				if (!controlTile(tileToCheck)) {

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