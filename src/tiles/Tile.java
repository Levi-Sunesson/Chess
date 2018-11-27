package tiles;

import java.util.ArrayList;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import pieces.King;
import pieces.Piece;
import pieces.Rook;

public class Tile extends Group {

	public static final double SIZE = 125;
	private Rectangle bg;
	private Color originalColor;
	public Piece piece;
	public static Tile active;
	public static ArrayList<Tile> moveMarked = new ArrayList<Tile>();
	private boolean locked = false;
	private static Color turn = Color.WHITE;

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
				
				if (this.piece instanceof King) {
					System.out.println("THE KING IS DEAD");
					
					for (ArrayList<Tile> ar : Board.allTiles) {
						
						for (Tile tile : ar) {
							
							tile.lock();
							
						}
						
					}
					
				}
				
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

				boardCheck(this);
				
				return;
			}

			if (hasRockadMark() && active != null) {

				int activeRow = active.row();

				active.makeInactive();
				rockadAction(activeRow);

				if (this.piece instanceof King) {
					if (turn == Color.WHITE) 
						Board.whiteKing = this;				
					else 
						Board.blackKing = this;

				}

				Board.changeTurn();

				boardCheck(this);

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

	public static void breaksCheck() {
		
		boardCheck(Board.checkTile);
		
	}
	
	public static void boardCheck(Tile attackerTile) {

		if (Board.checkTile != null && Board.checkTile != attackerTile) {
			
			boardCheck(Board.checkTile);
			
		}
		
		Tile oldActive = active;

		attackerTile.makeActive();
		
		for (int i = 1; i <= 2; i++) {
			Tile king = (i%2 == 0) ? Board.blackKing : Board.whiteKing;
		
			if(king.hasMoveMark()) {
				king.getBackground().setFill(Color.YELLOW);

				Board.checkTile = attackerTile;
			}else {

				king.getBackground().setFill(king.originalColor);

			}
			
		}

		active.makeInactive();

		active = oldActive;

	}

	public static void rockadSetup(int row) {

		ArrayList<Tile> rowArray = Board.allTiles.get(row);
		
		if (
				rowArray.get(4).piece instanceof King 	&&
				!rowArray.get(4).piece.hasMoved()		&&

				rowArray.get(7).piece instanceof Rook 	&&
				!rowArray.get(7).piece.hasMoved()		&&

				!rowArray.get(5).hasPiece() 			&&
				!rowArray.get(6).hasPiece()				&&
				rowArray.get(4).getPieceColor() == rowArray.get(7).getPieceColor()

				) {

			rowArray.get(7).rockadMark();

		}

	}

	public static void rockadAction(int row) {

		ArrayList<Tile> rowArray = Board.allTiles.get(row);

		if (
				rowArray.get(4).piece instanceof King 	&&
				!rowArray.get(4).piece.hasMoved()		&&

				rowArray.get(7).piece instanceof Rook 	&&
				!rowArray.get(7).piece.hasMoved()		&&

				!rowArray.get(5).hasPiece() 			&&
				!rowArray.get(6).hasPiece()

				) {


			rowArray.get(4).piece.move();
			rowArray.get(7).piece.move();

			rowArray.get(6).addPiece(rowArray.get(4).piece);
			rowArray.get(5).addPiece(rowArray.get(7).piece);

			rowArray.get(4).piece = null;
			rowArray.get(7).piece = null;

		}

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
		Circle cir = new Circle(SIZE / 2, SIZE / 2, SIZE / 3, Color.TRANSPARENT);
		cir.setStroke(Color.RED);
		cir.setStrokeWidth(SIZE/20);
		this.getChildren().add(cir);
		moveMarked.add(this);
	}

	private void rockadMark() {

		Rectangle rec = new Rectangle(SIZE/10, SIZE/10, SIZE*8/10, SIZE*8/10);
		rec.setArcHeight(rec.getHeight());
		rec.setArcWidth(rec.getWidth());
		rec.setStroke(Color.GREEN);
		rec.setStrokeWidth(SIZE/20);
		rec.setFill(Color.TRANSPARENT);

		this.getChildren().add(rec);
		moveMarked.add(this);
	}

	private boolean hasRockadMark() {

		return this.getChildren().get(this.getChildren().size() - 1) instanceof Rectangle;

	}

	private void makeActive() {
		if (active != null) {
			active.makeInactive();
		}

		active = this;

		if (!locked && this.piece != null) {
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