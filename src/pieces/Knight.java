package pieces;

import javafx.scene.image.Image;

public class Knight extends Piece {

	static Image White = new Image("file:chessPieces/tile004.png");
	static Image Black = new Image("file:chessPieces/tile010.png");
	
	public Knight(String color) {
		
			super(White, Black, color);
			
	}


	@Override
	public void move() {
		
	}

}
