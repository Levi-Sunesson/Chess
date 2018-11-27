package pieces;

import javafx.scene.paint.Color;

public class Bishop extends Piece {

	public Bishop(Color c) {

		super(c);

	}

	@Override
	public void showMove(int row, int col) {

		diagonalMove(row, col);
		
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub
		
	}

}
