package pieces;

import javafx.scene.paint.Color;
import tiles.*;

public class Knight extends Piece {
	
	public Knight(Color c) {
		
			super(c);
			
	}

	@Override
	public void showMove(int row, int col) {

		int x;
		int y;
		
		for (int i = 0; i <= 4; i++) {
			
			if (i % 2 != 0) {
				// 1 and 3
				
				
				// If 3 then check up else check down
				x = (i%3 == 0) ? 2 : -2;
				
				for (int j = 0; j <= 2; j++) {
					
					//Check Right then left
					y = (j%2 == 0) ? 1 : -1;
				
					if (
							!(row+x >= 0) ||
							!(row+x < Board.allTiles.size()) ||
							!(col+y >= 0) ||
							!(col+y < Board.allTiles.size())) {
						continue;
					}
					
					Tile tileToCheck = Board.allTiles.get(row + x).get(col + y);
					
					if (!tileToCheck.hasPiece()) {

						tileToCheck.moveMark();

					}else if (tileToCheck.hasPiece()) {
						
						if (tileToCheck.getPieceColor() != this.getColor()) {
						
							tileToCheck.moveMark();
							continue;
							
						}
						
					}
					
				}
				
			}

			if (i % 2 == 0) {
				// 2 and 4
				
				// If 4 then check up else check down
				y = (i%4 == 0) ? 2 : -2;
				
				for (int j = 0; j <= 2; j++) {
					
					//Check Right then left
					x = (j%2 == 0) ? 1 : -1;
				
					if (
							!(row+x >= 0) ||
							!(row+x < Board.allTiles.size()) ||
							!(col+y >= 0) ||
							!(col+y < Board.allTiles.size())) {
						continue;
					}
					
					Tile tileToCheck = Board.allTiles.get(row + x).get(col + y);
					if (!tileToCheck.hasPiece()) {

						tileToCheck.moveMark();

					}else if (tileToCheck.hasPiece()) {
						
						if (tileToCheck.getPieceColor() != this.getColor()) {
						
							tileToCheck.moveMark();
							continue;
							
						}
						
					}
					
				}
				
			}
			
		}
		

	}

	@Override
	public void move() {
		
	}
	

}