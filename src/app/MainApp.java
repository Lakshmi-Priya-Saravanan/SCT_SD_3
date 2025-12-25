package app;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainApp extends Application {

    @Override
    public void start(Stage stage) {

        SudokuGrid grid = new SudokuGrid();
        SudokuSolver solver = new SudokuSolver();

        Button solveBtn = new Button("Solve Sudoku");

        solveBtn.setOnAction(e -> {
            int[][] board = grid.getBoard();
            solver.solve(board);
            grid.setBoard(board);
        });

        VBox layout = new VBox(10);
        layout.getChildren().addAll(grid.createGrid(), solveBtn);
        layout.setStyle("-fx-padding: 20");

        stage.setTitle("SCT_SD_3 - Sudoku Solver");
        stage.setScene(new Scene(layout));
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
