package exercise.game.validator.service.sudoku;

import exercise.game.validator.service.GameValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * Responsible of validate sudoku board
 */
@Service
public class SudokuValidator implements GameValidator<char[][]> {
    private final char emptyCell;
    private final int boxSize;

    /**
     * SudokuValidator construcor
     *
     * @param emptyCell character that represents the empty cell value
     * @param boxSize size of the boxes in the sudoku, take into account
     *                that the box must be a square
     */
    @Autowired
    public SudokuValidator(@Value("${exercise.game.validator.sudoku.cell.empty}") final char emptyCell,
                           @Value("${exercise.game.validator.sudoku.boc.size}") final int boxSize) {
        this.emptyCell = emptyCell;
        this.boxSize = boxSize;
    }

    /**
     *  Validates sudoku board.
     *
     * Note: This approach achievement is not iterate the matrix many times like in naive
     * approach like iterate all column, then row and then boxes, in this implementation
     * the matrix is scanned just ones O(n)
     * This approach not only support 9,9 board it is dynamic based on the input.
     *
     * @param board
     * @return
     */
    @Override
    public boolean isValidSudoku(final char[][] board) {
        BoardValidator.validate(board, boxSize);

        LineValidator<Character> columnValidator = new LineValidator<>(board.length);
        LineValidator<Character> rowValidator = new LineValidator<>(board.length);
        BoxesValidator<Character> boxesValidator = new BoxesValidator(boxSize, board.length);

        int rowIndex = 0;
        int columnIndex = 0;
        boolean result = true;
        do {
            char element = board[columnIndex][rowIndex];
            if (element != emptyCell) {
                if (!rowValidator.validate(element, rowIndex)) {
                    result = false;
                    break;
                }

                if (!columnValidator.validate(element, columnIndex)) {
                    result = false;
                    break;
                }

                if (!boxesValidator.validate(element, rowIndex)) {
                    result = false;
                    break;
                }
            }

            if (rowIndex == board.length - 1) {
                if ((columnIndex + 1) % boxSize == 0) {
                    boxesValidator.resetBoxes();
                }
                columnIndex++;
                rowIndex = 0;
            } else {
                rowIndex++;
            }
        } while (columnIndex < board.length);

        return result;
    }
}
