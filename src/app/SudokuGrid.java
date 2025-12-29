package app;

import javafx.geometry.Pos;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class SudokuGrid {

    private TextField[][] cells = new TextField[9][9];

    public GridPane createGrid() {
        GridPane grid = new GridPane();

        // ➕ Visual spacing & alignment (added)
        grid.setHgap(3);
        grid.setVgap(3);
        grid.setAlignment(Pos.CENTER);
        grid.setStyle(
                "-fx-padding: 15;" +
                        "-fx-background-color: linear-gradient(to bottom, #f5f7fa, #c3cfe2);" +
                        "-fx-background-radius: 15;"
        );

        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {

                TextField tf = new TextField();
                tf.setPrefWidth(42);
                tf.setPrefHeight(42);

                // ➕ Rich cell styling (added only)
                tf.setStyle(
                        "-fx-alignment: center;" +
                                "-fx-font-size: 15;" +
                                "-fx-font-weight: bold;" +
                                "-fx-text-fill: #263238;" +
                                "-fx-background-color: linear-gradient(#ffffff, #e3f2fd);" +
                                "-fx-border-color: #90a4ae;" +
                                "-fx-border-width: 1;" +
                                "-fx-background-radius: 8;" +
                                "-fx-border-radius: 8;"
                );

                // ➕ 3×3 box highlight colors (visual only)
                if ((row / 3 + col / 3) % 2 == 0) {
                    tf.setStyle(tf.getStyle() +
                            "-fx-background-color: linear-gradient(#ffffff, #e8f5e9);");
                }

                // ➕ Bold borders for Sudoku blocks (added)
                if (col % 3 == 0) tf.setStyle(tf.getStyle() + "-fx-border-left-width: 3;");
                if (row % 3 == 0) tf.setStyle(tf.getStyle() + "-fx-border-top-width: 3;");
                if (col == 8) tf.setStyle(tf.getStyle() + "-fx-border-right-width: 3;");
                if (row == 8) tf.setStyle(tf.getStyle() + "-fx-border-bottom-width: 3;");

                // ➕ Focus glow effect (added)
                tf.focusedProperty().addListener((obs, oldVal, newVal) -> {
                    if (newVal) {
                        tf.setStyle(tf.getStyle() +
                                "-fx-background-color: #fff9c4;" +
                                "-fx-border-color: #fbc02d;" +
                                "-fx-border-width: 2;");
                    }
                });

                cells[row][col] = tf;
                grid.add(tf, col, row);
            }
        }
        return grid;
    }

    // 🔒 EXISTING LOGIC — UNCHANGED
    public int[][] getBoard() {
        int[][] board = new int[9][9];

        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                String value = cells[row][col].getText();
                board[row][col] = value.isEmpty() ? 0 : Integer.parseInt(value);
            }
        }
        return board;
    }

    // 🔒 EXISTING LOGIC — UNCHANGED
    public void setBoard(int[][] board) {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (board[row][col] != 0) {
                    cells[row][col].setText(String.valueOf(board[row][col]));
                }
            }
        }
    }
}


