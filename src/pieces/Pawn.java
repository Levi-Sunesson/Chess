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
		if (this.getColor() == Color.BLACK) {

			if (Board.allTiles.size() <= row + 1) {
				return;
			}

			if (col+1 <= 7) {
				if (Board.allTiles.get(row + 1).get(col + 1).hasPiece()) {
					if (Board.allTiles.get(row + 1).get(col + 1).getPieceColor() != this.getColor())
						Board.allTiles.get(row + 1).get(col + 1).moveMark();
				}
			}
			if (col-1 >= 0) {
				if (Board.allTiles.get(row + 1).get(col - 1).hasPiece()) {
					if (Board.allTiles.get(row + 1).get(col - 1).getPieceColor() != this.getColor())
						Board.allTiles.get(row + 1).get(col - 1).moveMark();
				}
			}
			if (Board.allTiles.get(row + 1).get(col).hasPiece()) {
				return;
			}
			Board.allTiles.get(row + 1).get(col).moveMark();

			if (Board.allTiles.size() <= row + 2 || hasMoved) {
				return;
			}
			if (Board.allTiles.get(row + 2).get(col).hasPiece()) {
				return;
			}

			Board.allTiles.get(row + 2).get(col).moveMark();
		} else if (this.getColor() == Color.WHITE) { // ELLER else{

			if (0 > row - 1) {
				return;
			}
			if (col+1 <= 7) {

				if (Board.allTiles.get(row - 1).get(col + 1).hasPiece()) {
					if (Board.allTiles.get(row - 1).get(col + 1).getPieceColor() != this.getColor())
						Board.allTiles.get(row - 1).get(col + 1).moveMark();
				}
			}
			if (col-1 >= 0) {

				if (Board.allTiles.get(row - 1).get(col - 1).hasPiece()) {
					if (Board.allTiles.get(row - 1).get(col - 1).getPieceColor() != this.getColor())
						Board.allTiles.get(row - 1).get(col - 1).moveMark();
				}
			}
			if (Board.allTiles.get(row - 1).get(col).hasPiece()) {
				return;
			}

			Board.allTiles.get(row - 1).get(col).moveMark();

			if (0 > row - 2 || hasMoved) {
				return;
			}
			if (Board.allTiles.get(row - 2).get(col).hasPiece()) {
				return;
			}

			Board.allTiles.get(row - 2).get(col).moveMark();
		}
	}

}