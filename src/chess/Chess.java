package chess;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import tiles.Board;

public class Chess extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		Board board = new Board();
		
		Scene scene = new Scene(board, 800, 800);

		PlayerBlack blackP = new PlayerBlack();
		blackP.setTranslateY(600);
		PlayerWhite whiteP = new PlayerWhite();
		
		board.getChildren().add(blackP);
		board.getChildren().add(whiteP);
		
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
