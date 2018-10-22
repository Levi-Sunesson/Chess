package tiles;

import javafx.scene.Group;

public class Board extends Group{

	public Board() {
		
		this.setTranslateX(5);
		this.setTranslateY(5);
		
		boolean alt = false;
		
		for (int rows = 0; rows < 8; rows++) {
			for (int cols = 0; cols < 8; cols++) {
			
				if(alt) {
					this.getChildren().add(new BlackTile());
					alt = false;
				}else{
					this.getChildren().add(new WhiteTile());
					alt = true;
				}
				
				this.getChildren().get(this.getChildren().size() - 1).setTranslateY(rows * Tile.SIZE);
				this.getChildren().get(this.getChildren().size() - 1).setTranslateX(cols * Tile.SIZE);
					
			}
			
			if (alt) {
				alt = false;
			}
			else {
				alt = true;
			}
		}
	}
}