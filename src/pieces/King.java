package pieces;

import javafx.scene.image.Image;

public class King extends Piece{

	static Image White = new Image("file:chessPieces/tile001.png");
	static Image Black = new Image("file:chessPieces/tile007.png");
	
	public King(String color) {
		
			super(White, Black, color);
			
	}


	@Override
	public void move() {
		
	}

	
}
