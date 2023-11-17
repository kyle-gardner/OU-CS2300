package tic;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import java.io.IOException;

public class App extends Application {

    private static Scene scene;
	private TilePane playerBoard;
	private Board currentBoard;
	private Scene currentScene;
	private Stage currentStage;

    @Override
    public void start(Stage stage) throws IOException {
		this.currentBoard = new Board();
		StackPane root = newRoot();
		this.currentStage = stage;

		scene = new Scene(root, 640, 640);
		stage.setScene(scene);
		currentScene = scene;
		
		stage.setTitle("Red's turn");
		stage.show();
    }
	public StackPane newRoot() {
		StackPane root = new StackPane();

		root.getChildren().add(makeBoard());
		root.getChildren().add(makePlayers());
		
		return root;
	} 
	public TilePane makeBoard() {
		TilePane board = new TilePane();
		board.setPrefColumns(5);
		board.setPrefRows(5);
		board.setTileAlignment(Pos.CENTER);
		board.setPrefSize(640, 640);

		board.setMinHeight(TilePane.USE_PREF_SIZE);
		board.setMinWidth(TilePane.USE_PREF_SIZE);
		
		int size = 640/5;
		for (int i = 0; i < 25; i++) {
			if (i % 2 == 0) {
				board.getChildren().add(new Rectangle(size, size, Color.BLACK));
			} else {
				board.getChildren().add(new Rectangle(size, size, Color.WHITE));
			}
		}
		
		return board;
	} 
	public TilePane makePlayers() {
		TilePane playerBoard = new TilePane();

		playerBoard.setPrefColumns(5);
		playerBoard.setPrefRows(5);
		playerBoard.setTileAlignment(Pos.CENTER);
		playerBoard.setPrefSize(640, 640);

		double radius = (640/5)/2;

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				Circle circ = new Circle(radius, currentBoard.board[i][j].color);

				final int eye = i;
				final int jay = j;
				circ.setOnMouseClicked((e) -> {
					if (circ.getFill() == Color.TRANSPARENT) {
						if (currentBoard.turn % 2 == 0) {
							currentBoard.board[eye][jay] = new RedPiece();
							currentBoard.turn += 1;
							currentStage.setTitle("Blue's turn");
						} else {
							currentBoard.board[eye][jay] = new BluePiece();
							currentBoard.turn += 1;
							currentStage.setTitle("Red's turn");
						}
						if (currentBoard.checkWin()) {
							currentStage.setTitle("WINNER! reopen to play again");
							
						}

						StackPane newRoot = newRoot();
						currentScene.setRoot(newRoot);
					}
				});

				playerBoard.getChildren().add(circ);
			}
		}

		this.playerBoard = playerBoard;
		return playerBoard;
	}
	
    public static void main(String[] args) {
        launch();
    }
}