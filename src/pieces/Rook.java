package pieces;

import javafx.scene.paint.Color;
import tiles.*;

public class Rook extends Piece {

	//TORN
	
	public Rook(Color c) {

		super(c);

	}

	@Override
	public void showMove(int row, int col) {
		
		int n;
		
		for (int i = 1; i < 5; i++) {
			
			System.out.println(i);
			
			if (i%2 == 0) {
				
				//Up & down = col
				
				n = 0;
				
				int x = (i % 4 == 0) ? 1 : -1;
				
				while(true) {
					
					if (col + n < 0 || col + n > Board.allTiles.get(row).size()) {
						break;
					}
					
					Tile tileToCheck = Board.allTiles.get(row).get(col+n);
					
					if (!tileToCheck.hasPiece()) {
						
						tileToCheck.moveMark();
						
					}
					
					n += x;
					
				}
				
			}else {
				
				//Right & Left = row
				
				n = 0;
				
				int x = (i % 3 == 0) ? 1 : -1;
				
				while(true) {
					
					System.out.println(row + " " + n);
					
					if (row + n < 0 || row + n > Board.allTiles.size()) {
						break;
					}
					
					Tile tileToCheck = Board.allTiles.get(row+n).get(col);
					
					if (!tileToCheck.hasPiece()) {
						
						tileToCheck.moveMark();
						
					}
					
					n += x;
					
				}
				
			}

		}

			
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub
		
	}



}