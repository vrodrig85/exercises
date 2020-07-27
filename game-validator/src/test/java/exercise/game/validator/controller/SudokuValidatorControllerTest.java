package exercise.game.validator.controller;

import exercise.game.validator.model.SudokuBoard;
import exercise.game.validator.model.ValidationResponse;
import exercise.game.validator.model.ValidationResult;
import exercise.game.validator.service.sudoku.SudokuValidator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import static exercise.game.validator.BoardConstants.*;

public class SudokuValidatorControllerTest {
    private SudokuValidatorController underTest = new SudokuValidatorController();
    private SudokuValidator sudokuValidator;
    private SudokuBoard sudokuBoard;

    @BeforeEach
    public void setup(){
        sudokuValidator = new SudokuValidator('.', 3);
        underTest.setSudokuValidator(sudokuValidator);
    }

    @Test
    public void testNullBoard(){
        givenBoardRequest(null);
        Assertions.assertThrows(IllegalArgumentException.class, () -> underTest.validateBoard(sudokuBoard));
    }

    @Test
    public void testNullRequest(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> underTest.validateBoard(null));
    }

    @Test
    public void testValidBoard(){
        givenBoardRequest(VALID_BOARD);

        ResponseEntity<ValidationResponse<char[][]>> response = underTest.validateBoard(sudokuBoard);

        Assert.notNull(response, "Response can not be null");
        Assert.isTrue(response.getStatusCode().equals(HttpStatus.OK), "Status must be 200");
        Assert.isTrue(response.getBody().getValidationResult().equals(ValidationResult.SUCCESSFUL),
                "Validation result must be SUCCESSFUL");
        Assert.isTrue(response.getBody().getBoard().equals(VALID_BOARD),
                "Board in response must be equals that the request board");
    }

    @Test
    public void testBoardInvalidRow(){
        givenBoardRequest(INVALID_ROW_BOARD);

        ResponseEntity<ValidationResponse<char[][]>> response = underTest.validateBoard(sudokuBoard);

        Assert.notNull(response, "Response can not be null");
        Assert.isTrue(response.getStatusCode().equals(HttpStatus.OK), "Status must be 200");
        Assert.isTrue(response.getBody().getValidationResult().equals(ValidationResult.FAILED),
                "Validation result must be SUCCESSFUL");
        Assert.isTrue(response.getBody().getBoard().equals(INVALID_ROW_BOARD),
                "Board in response must be equals that the request board");
    }

    @Test
    public void testBoardInvalidColumn(){
        givenBoardRequest(INVALID_COLUMN_BOARD);

        ResponseEntity<ValidationResponse<char[][]>> response = underTest.validateBoard(sudokuBoard);

        Assert.notNull(response, "Response can not be null");
        Assert.isTrue(response.getStatusCode().equals(HttpStatus.OK), "Status must be 200");
        Assert.isTrue(response.getBody().getValidationResult().equals(ValidationResult.FAILED),
                "Validation result must be SUCCESSFUL");
        Assert.isTrue(response.getBody().getBoard().equals(INVALID_COLUMN_BOARD),
                "Board in response must be equals that the request board");
    }

    @Test
    public void testBoardInvalidBox(){
        givenBoardRequest(INVALID_BOX_BOARD_1);

        ResponseEntity<ValidationResponse<char[][]>> response = underTest.validateBoard(sudokuBoard);

        Assert.notNull(response, "Response can not be null");
        Assert.isTrue(response.getStatusCode().equals(HttpStatus.OK), "Status must be 200");
        Assert.isTrue(response.getBody().getValidationResult().equals(ValidationResult.FAILED),
                "Validation result must be SUCCESSFUL");
        Assert.isTrue(response.getBody().getBoard().equals(INVALID_BOX_BOARD_1),
                "Board in response must be equals that the request board");
    }

    private void givenBoardRequest(char[][] board){
        sudokuBoard = new SudokuBoard();
        sudokuBoard.setBoard(board);
    }
}
