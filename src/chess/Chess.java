package chess;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import tiles.Board;
import tiles.Tile;

public class Chess extends Application{

	public static Group root = new Group();
	
	private static Board board = new Board();
	
	@Override
	public void start(Stage primaryStage) throws Exception {

		root.getChildren().add(board);
		
		
		Scene scene = new Scene(root, 8 * Tile.SIZE, 8 * Tile.SIZE, Color.WHITE);

		primaryStage.getIcons().add(new Image("images/WHITE_KING.png"));
		primaryStage.setResizable(false);
		primaryStage.setTitle("Chess");
		primaryStage.setScene(scene);

		primaryStage.sizeToScene();
		primaryStage.show();

	}
	
	public static void end(String winner) {
		
		board.end(winner);
		
	}

	public static void main(String[] args) {
		launch(args);
	}

}
