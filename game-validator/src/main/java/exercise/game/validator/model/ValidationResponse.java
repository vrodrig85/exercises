package exercise.game.validator.model;

/**
 * Represents SudokuValidatorController response.
 *
 * @param <T>
 */
public class ValidationResponse <T> {
    private ValidationResult validationResult;
    private T board;

    /**
     * Constructor
     *
     * @param validationResult
     * @param board
     */
    public ValidationResponse(ValidationResult validationResult, T board) {
        this.validationResult = validationResult;
        this.board = board;
    }

    /**
     * Gets validation result
     * @return ValidationResult
     */
    public ValidationResult getValidationResult() {
        return validationResult;
    }

    /**
     * Sets validation result.
     *
     * @param validationResult
     */
    public void setValidationResult(ValidationResult validationResult) {
        this.validationResult = validationResult;
    }

    /**
     * Gets requested board.
     *
     * @return
     */
    public T getBoard() {
        return board;
    }

    /**
     *  Sets requested board.
     *
     * @param board
     */
    public void setBoard(T board) {
        this.board = board;
    }
}