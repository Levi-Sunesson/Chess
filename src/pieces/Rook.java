package pieces;

import javafx.scene.paint.Color;
import tiles.*;

public class Rook extends Piece {

	//TORN

	public boolean hasMoved = false;
	
	public Rook(Color c) {

		super(c);

	}

	@Override
	public void showMove(int row, int col) {

		if (col == 7 && !hasMoved) {
			Tile.rockadSetup(row);	
		}
		
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

					if (!tileToCheck.hasPiece()) {

						tileToCheck.moveMark();

					}else if (tileToCheck.hasPiece()) {
						
						if (tileToCheck.getPieceColor() != this.getColor()) {
						
							tileToCheck.moveMark();
							
							
						}
						
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

					if (!tileToCheck.hasPiece()) {

						tileToCheck.moveMark();

					}else if (tileToCheck.hasPiece()) {
						
						if (tileToCheck.getPieceColor() != this.getColor()) {
						
							tileToCheck.moveMark();
							
						}
						
						break;
						
					}

					n += x;

				}

			}

		}

	}

	@Override
	public void move() {

		hasMoved = true;
		
	}

}