package tiles;

import java.util.ArrayList;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
//import pieces.Pawn;
import pieces.Piece;

public class Tile extends Group {

	public static final double SIZE = 100;
	private Rectangle bg;
	private Color originalColor;
	private Piece piece;
	public static Tile active;
	//private int turnCounter = 1;
	public static ArrayList<Tile> moveMarked = new ArrayList<Tile>();

	public Tile(Color c) {
		originalColor = c;
		bg = new Rectangle(SIZE, SIZE, c);
		this.getChildren().add(bg);

		this.setOnMouseClicked(event -> {

			if (this == active) {
				this.makeInactive();
				return;
			}
			
			if (hasMoveMark()) {
				Piece p = active.piece;
				active.piece = null;
				active.makeInactive();
				this.addPiece(p);
				this.piece.move();
				return;
			}

			// EXEMPEL:
			if (hasPiece()) {
				makeActive();

				

			} else {
				if (active != null) {

					active.makeInactive();
				}

			}

		});

	}

	private boolean hasMoveMark() {

		return this.getChildren().get(this.getChildren().size() - 1) instanceof Circle;

	}

	private int col() {
		for (int i = 0; i < Board.allTiles.size(); i++) {
			if (Board.allTiles.get(i).contains(this)) {
				return Board.allTiles.get(i).indexOf(this);
			}
		}
		return -1;
	}

	public int row() {
		for (int i = 0; i < Board.allTiles.size(); i++) {
			if (Board.allTiles.get(i).contains(this)) {
				return i;
			}
		}
		return -1;
	}

	public void moveMark() {
		if (this.hasPiece()) {
			// OM OLIKA FÄRG
			if (this.piece.getColor() != active.piece.getColor()) {
				attackMark();
			}
			return;
		}

		Circle cir = new Circle(SIZE / 2, SIZE / 2, SIZE / 8);
		this.getChildren().add(cir);
		moveMarked.add(this);
	}

	private void attackMark() {
		Circle cir = new Circle(SIZE / 2, SIZE / 2, SIZE / 8, Color.RED);
		this.getChildren().add(cir);
		moveMarked.add(this);
	}

	private void makeActive() {
		if (active != null) {
			active.makeInactive();
		}

		active = this;
		
		this.piece.showMove(row(),col());

		this.getBackground().setFill(Color.RED);

	}

	private void makeInactive() {
		for (Tile tile : moveMarked) {
			tile.removeMoveMark();
		}
		moveMarked.clear();
		active = null;
		this.getBackground().setFill(originalColor);

	}

	private void removeMoveMark() {
		this.getChildren().remove(this.getChildren().size() - 1);

	}

	public void addPiece(Piece p) {
		if (this.piece != null) {
			this.getChildren().remove(this.piece);
		}
		this.piece = p;
		this.getChildren().add(p);
	}

	public boolean hasPiece() {
		return this.piece != null;
	}
	
	public Color getPieceColor(){
		return this.piece.getColor();
	}

	public Rectangle getBackground() {
		return this.bg;
	}

	public Boolean turn(int i) {
		boolean whiteTurn = true;
		if (i % 2 == 0) {
			return whiteTurn = false;
		} else {
			return whiteTurn;
		}
	}

}