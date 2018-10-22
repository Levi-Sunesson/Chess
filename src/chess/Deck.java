package chess;

import java.util.ArrayList;
import javafx.scene.Group;
import pieces.*;
import tiles.Tile;

public abstract class Deck extends Group{

	ArrayList<Piece> pieces = new ArrayList<Piece>();
	
	public Deck(String color) {
		
		
		if (color.equals("Black")) {
			
			Pawns(color);
			SecRow(color);
			
		}
		
		if (color.equals("White")) {
			
			SecRow(color);
			Pawns(color);
		}
		
		for (int i = 0; i < 2; i++) {
			for (int j = 0 ; j < 8 ; j++) {
				
				pieces.get(i * 8 + j).setTranslateX((j) * 100);
				pieces.get(i * 8 + j).setTranslateY((i) * 100);
				
			}
		}
		
		
		for (Piece p : pieces) {
			this.getChildren().add(p);
		}
		
	}
	
	private void SecRow(String color) {
		
		pieces.add(new Rook(color));
		pieces.add(new Knight(color));
		pieces.add(new Bishop(color));
		pieces.add(new Queen(color));
		pieces.add(new King(color));
		pieces.add(new Bishop(color));
		pieces.add(new Knight(color));
		pieces.add(new Rook(color));
		
		
		
		
	}
	
	private void Pawns(String color) {
		
		for (int i = 0; i < 8; i++) {
			
			Pawn p = new Pawn(color);
			p.setTranslateX(i * Tile.SIZE);
			pieces.add(p);
		}
		
	}
	
}
