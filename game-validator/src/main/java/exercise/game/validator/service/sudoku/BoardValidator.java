package exercise.game.validator.service.sudoku;

import java.util.Objects;

/**
 * Responsible of validate the board configuration itself,
 * does not validates the elements in the array
 */
public class BoardValidator {

    /**
     * Validates sudoku board according that:
     * - must be a square
     * - box size must fit in the board
     *
     * @param board   sudoku board representation as a bi-dimensional array
     * @param boxSize size of box, take into account that the box must be a square
     */
    public static void validate(final char[][] board, final int boxSize) {
        IsNonEmpty(board);
        isSquare(board);
        isBoxConfigurationValid(boxSize, board.length);
    }

    /**
     * Checks that the board is a square.
     *
     * @param board
     */
    private static void isSquare(final char[][] board) {
        int columnLength = board.length;
        for (int i = 0; i < columnLength; i++) {
            if (board[i].length != columnLength) {
                throw new IllegalArgumentException("Board must to be a square");
            }
        }
    }

    /**
     * Checks that the boxes configuration is valid.
     *
     * @param boxSize
     * @param boardSize
     */
    private static void isBoxConfigurationValid(final int boxSize,
                                                final int boardSize) {
        if (boardSize % boxSize != 0) {
            throw new IllegalArgumentException("The size of the board must be divisible by the size of the box");
        }
    }

    /**
     * Check that the board is non null neither size zero array
     *
     * @param board board to be validate
     */
    private static void IsNonEmpty(final char[][] board){
        if(Objects.isNull(board) || board.length <= 0){
            throw new IllegalArgumentException("Board can not be null");
        }
    }
}
