package app;

import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class SudokuGrid {

    private TextField[][] cells = new TextField[9][9];

    public GridPane createGrid() {
        GridPane grid = new GridPane();

        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                TextField tf = new TextField();
                tf.setPrefWidth(40);
                tf.setPrefHeight(40);
                tf.setStyle("-fx-alignment: center; -fx-font-size: 14;");
                cells[row][col] = tf;
                grid.add(tf, col, row);
            }
        }
        return grid;
    }

    public int[][] getBoard() {
        int[][] board = new int[9][9];
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                String text = cells[r][c].getText();
                board[r][c] = text.isEmpty() ? 0 : Integer.parseInt(text);
            }
        }
        return board;
    }

    public void setBoard(int[][] board) {
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                cells[r][c].setText(board[r][c] == 0 ? "" : String.valueOf(board[r][c]));
            }
        }
    }
}
