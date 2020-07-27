package exercise.game.validator.service;

import exercise.game.validator.service.sudoku.BoardValidator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static exercise.game.validator.BoardConstants.*;

public class BoardValidatorTest {

    @Test
    public void testValidBoard(){
        BoardValidator.validate(VALID_BOARD, 3);
    }

    @Test
    public void testNoSquare1(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            BoardValidator.validate(NO_SQUARE_BOARD_1, 3);
        });
    }

    @Test
    public void testNoSquare2(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            BoardValidator.validate(NO_SQUARE_BOARD_2, 3);
        });
    }

    @Test
    public void testNullBoard(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            BoardValidator.validate(null, 3);
        });
    }

    @Test
    public void testEmptyBoard(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            BoardValidator.validate(EMPTY, 3);
        });
    }

    @Test
    public void testWrongBoxSize(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            BoardValidator.validate(VALID_BOARD, 4);
        });
    }
}
