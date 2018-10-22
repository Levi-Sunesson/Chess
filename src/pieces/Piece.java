package pieces;

import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public abstract class Piece extends Group{

	public String color;
	
	public Piece(Image imageWhite, Image imageBlack, String color){
		
		this.color = color;
		
		ImageView iw;
		
		if (color.equals("White")) {

	        iw = new ImageView(imageWhite);
	        
		}else {
			
			iw = new ImageView(imageBlack);
			
		}
		
        iw.setFitWidth(100);
        iw.setFitHeight(100);
		
		this.getChildren().add(iw);
		
	}
	
	public abstract void move();
	
}
