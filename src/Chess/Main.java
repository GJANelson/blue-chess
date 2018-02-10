package Chess;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Runs the chess program.
 * @author Garth Nelson
 * @version 2018
 */
public class Main extends Application {

    /**
     * Creates the chessboard and starts the game.
     * @see javafx.application.Application#start(javafx.stage.Stage)
     * @param primaryStage
     * @throws Exception
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        Chessboard gameboard = new Chessboard();
        Scene scene = new Scene(gameboard.getBoard());
        primaryStage.setTitle("Chess");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * Drives the program.
     * @param args unused
     */
    public static void main(String[] args) {
        launch(args);
    }

}
