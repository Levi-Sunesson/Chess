package pieces;

import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import tiles.Tile;

public abstract class Piece extends Group implements Moveable{

	private Color color;
	
	public Piece(Color c) {
		color = c;
		String COLOR = "WHITE";
		if (c == Color.BLACK) {
			COLOR = "BLACK";
		}

		Image img = new Image("images/" + COLOR + "_" + this.getClass().getSimpleName().toUpperCase() + ".png");
		ImageView iv = new ImageView(img);
		iv.setFitWidth(Tile.SIZE);
		iv.setFitHeight(Tile.SIZE);
		this.getChildren().add(iv);

	}

	public Color getColor() {
		return color;
	}
	
}
