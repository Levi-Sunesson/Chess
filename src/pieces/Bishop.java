package pieces;

import javafx.scene.paint.Color;

public class Bishop extends Piece {

	public Bishop(Color c) {

		super(c);

	}

	@Override
	public void showMove(int row, int col) {

		int n;

		for (int i = 1; i < 5; i++) {

			n = 0;

			int x = (i % 2 == 0) ? 1 : -1;

			while (true) {

				if (i <= 2) {

					n += 8 + x;

				} else {

					n -= 8 - x;

				}
				if (n>0
						//At edge
						) {
						
					break;
				
				}

				if (n>0
						//Has Piece
						) {

					if (n>0
						//Is enemy
							) {

						//kill it

					}

					break;

				}else {

					//tile.next(n).moveMark();


				}


			}

		}

	}

	@Override
	public void move() {
		// TODO Auto-generated method stub
		
	}

}
