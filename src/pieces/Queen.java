package pieces;

import javafx.scene.image.Image;

public class Queen extends Piece {

	static Image White = new Image("file:chessPieces/tile002.png");
	static Image Black = new Image("file:chessPieces/tile008.png");
	
	public Queen(String color) {
		
			super(White, Black, color);
			
	}


	@Override
	public void move() {
		
	}

	
}
