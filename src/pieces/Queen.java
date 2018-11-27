package pieces;

import javafx.scene.paint.Color;

public class Queen extends Piece {

	public Queen(Color c) {

		super(c);

	}

	@Override
	public void showMove(int row, int col) {
		
		diagonalMove(row, col);
		straightMove(row, col);

	}

	@Override
	public void move() {
		// TODO Auto-generated method stub

	}

}