package pieces;

import javafx.scene.image.Image;

public class Rook extends Piece {

	static Image White = new Image("file:chessPieces/tile005.png");
	static Image Black = new Image("file:chessPieces/tile011.png");
	
	public Rook(String color) {
		
			super(White, Black, color);
			
	}

	@Override
	public void move() {
		
	}

	
}
