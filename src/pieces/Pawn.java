package pieces;

import javafx.scene.paint.Color;
import tiles.*;

public class Pawn extends Piece {

	private boolean hasMoved = false;

	public Pawn(Color c) {

		super(c);

	}

	public void move() {
		hasMoved = true;
	}

	@Override
	public void showMove(int row, int col) {

		int n = (this.getColor() == Color.WHITE) ? -1 : 1;
		
		if (!(row+n >= 0) || !(row+n < Board.allTiles.size())) {
			return;
		}

		Tile tileToCheck = Board.allTiles.get(row+n).get(col);

		if (!tileToCheck.hasPiece()) {
			tileToCheck.moveMark();

			if (!hasMoved && !Board.allTiles.get(row+(2*n)).get(col).hasPiece()) {
				Board.allTiles.get(row+(2*n)).get(col).moveMark();
			}

		}

		for (int i = 1; i <= 2; i++) {
			
			int x = (i%2 == 0) ? -1 : 1;
			
			if ((col+x >= 0) && col+x < Board.allTiles.size()) {
				tileToCheck = Board.allTiles.get(row+n).get(col+x);

				if (tileToCheck.hasPiece()) tileToCheck.moveMark();
				
			}
			
		}
		
	}

}