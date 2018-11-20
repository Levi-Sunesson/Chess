package chess;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import tiles.Board;
import tiles.Tile;

public class Chess extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		Board board = new Board();
		
		Scene scene = new Scene(board, 8 * Tile.SIZE, 8 * Tile.SIZE, Color.DARKGREY);
		
		primaryStage.getIcons().add(new Image("file:chessPieces/tile001.png"));
		primaryStage.setResizable(false);
		primaryStage.setTitle("Chess");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
