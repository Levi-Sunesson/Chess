package pieces;

import javafx.scene.image.Image;

public class Pawn extends Piece {

	static Image White = new Image("file:chessPieces/tile006.png");
	static Image Black = new Image("file:chessPieces/tile012.png");

	public Pawn(String color) {

		super(White, Black, color);

	}


	@Override
	public void move() {

	}


}
