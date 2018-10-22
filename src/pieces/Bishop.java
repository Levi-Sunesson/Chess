package pieces;

import javafx.scene.image.Image;

public class Bishop extends Piece {

	static Image White = new Image("file:chessPieces/tile003.png");
	static Image Black = new Image("file:chessPieces/tile009.png");
	
	public Bishop(String color) {
		
			super(White, Black, color);
			
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub
		
	}

}
