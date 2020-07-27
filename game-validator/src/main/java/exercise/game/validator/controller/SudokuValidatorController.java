package exercise.game.validator.controller;

import exercise.game.validator.model.SudokuBoard;
import exercise.game.validator.model.ValidationResponse;
import exercise.game.validator.model.ValidationResult;
import exercise.game.validator.service.sudoku.SudokuValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SudokuValidatorController {
    @Autowired
    private SudokuValidator sudokuValidator;

    @RequestMapping(value = "/game/validator/sudoku/board/validate",
                    method = RequestMethod.GET,
                    produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ValidationResponse<char[][]>> validateBoard(@RequestBody SudokuBoard board){
        ResponseEntity<ValidationResponse<char[][]>> response;
        if(board == null){
            throw new IllegalArgumentException("Board can not be null");
        }

        if(sudokuValidator.isValidSudoku(board.getBoard())){
            response = new ResponseEntity<ValidationResponse<char[][]>>(new ValidationResponse(ValidationResult.SUCCESSFUL,
                                                                                               board.getBoard()),
                                                                                               HttpStatus.OK);
        } else {
            response = new ResponseEntity<ValidationResponse<char[][]>>(new ValidationResponse(ValidationResult.FAILED,
                                                                                               board.getBoard()),
                                                                                               HttpStatus.OK);
        }
        return response;
    }

    public void setSudokuValidator(SudokuValidator sudokuValidator) {
        this.sudokuValidator = sudokuValidator;
    }
}
