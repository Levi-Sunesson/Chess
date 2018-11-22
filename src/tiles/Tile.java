package tiles;

import java.util.ArrayList;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import pieces.King;
import pieces.Piece;

public class Tile extends Group {

	public static final double SIZE = 125;
	private Rectangle bg;
	private Color originalColor;
	private Piece piece;
	public static Tile active;
	public static ArrayList<Tile> moveMarked = new ArrayList<Tile>();
	private boolean locked = false;
	private Color turn = Color.WHITE;

	public Tile(Color c) {
		originalColor = c;
		bg = new Rectangle(SIZE, SIZE, c);
		this.getChildren().add(bg);

		this.setOnMouseClicked(event -> {

			if (this == active) {
				this.makeInactive();
				return;
			}

			turn = (Board.getTurn()%2 == 0) ? Color.WHITE : Color.BLACK;

			if (hasMoveMark()) {
				Piece p = active.piece;
				active.piece = null;
				active.makeInactive();
				this.addPiece(p);
				this.piece.move();

				if (this.piece instanceof King) {
					if (turn == Color.WHITE) 
						Board.whiteKing = this;				
					else 
						Board.blackKing = this;

				}
				Board.changeTurn();

				return;
			}

			if (hasPiece() && this.piece.getColor() == turn) {

				makeActive();

			} else {
				if (active != null) {

					active.makeInactive();
				}
			}
		});

	}

	public void lock() {

		if (this.hasPiece()) {
			locked = true;
		}

	}

	public void unlock() {

		locked = false;

	}

	public void changeLock() {

		if (this.hasPiece()) {
			if (locked) {
				locked = false;
			}else {

				locked = true;

			}

		}else {

			unlock();

		}

	}

	public boolean getLocked() {

		return locked;

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

		if (!locked) {
			this.piece.showMove(row(),col());

		}

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

}