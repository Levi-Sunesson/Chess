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
		
		straightMove(row, col);

	}

	@Override
	public void move() {

		hasMoved = true;
		
	}

}