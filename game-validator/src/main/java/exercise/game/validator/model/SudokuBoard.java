package exercise.game.validator.model;

/**
 * Represents sudoku board request
 */
public class SudokuBoard {
    private char[][] board;

    /**
     * Gets board.
     * @return
     */
    public char[][] getBoard() {
        return board;
    }

    /**
     * Sets board.
     * @param board
     */
    public void setBoard(char[][] board) {
        this.board = board;
    }
}
