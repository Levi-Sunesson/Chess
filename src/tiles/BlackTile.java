package tiles;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class BlackTile extends Tile{

	public BlackTile() {
		@SuppressWarnings("static-access")
		Rectangle r = new Rectangle(super.SIZE, super.SIZE);
		r.setFill(Color.DARKGREY);
		this.getChildren().add(r);
	}
	
}
