package tiles;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class WhiteTile extends Tile {

	public WhiteTile() {
		@SuppressWarnings("static-access")
		Rectangle r = new Rectangle(super.SIZE, super.SIZE);
		r.setFill(Color.LIGHTGREY);
		this.getChildren().add(r);
	}
	
}
