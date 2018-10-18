package chess;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import tiles.Board;

public class Chess extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		Board board = new Board();
		
		Scene scene = new Scene(board, 800, 800);
		
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
