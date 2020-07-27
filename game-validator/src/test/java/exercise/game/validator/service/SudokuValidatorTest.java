package exercise.game.validator.service;

import exercise.game.validator.service.sudoku.SudokuValidator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import static exercise.game.validator.BoardConstants.*;

public class SudokuValidatorTest {
    private SudokuValidator underTest;
    private char[][] board;

    @BeforeEach
    public void setup(){
        underTest = new SudokuValidator('.', 3);
    }

    @Test
    public void testNullBoard(){
        givenBoard(null);
        Assertions.assertThrows(IllegalArgumentException.class, () -> underTest.isValidSudoku(board));
    }

    @Test
    public void testNoSquareBoard(){
        givenBoard(NO_SQUARE_BOARD_1);
        Assertions.assertThrows(IllegalArgumentException.class, () -> underTest.isValidSudoku(board));
    }

    @Test
    public void testNoSquareBoard2(){
        givenBoard(NO_SQUARE_BOARD_2);
        Assertions.assertThrows(IllegalArgumentException.class, () -> underTest.isValidSudoku(board));
    }

    @Test
    public void testInvalidBoxBoard(){
        givenSudokuValidator('.', 4); //invalid box size
        givenBoard(VALID_BOARD);
        Assertions.assertThrows(IllegalArgumentException.class, () -> underTest.isValidSudoku(board));
    }

    @Test
    public void testValidBoard(){
        givenBoard(VALID_BOARD);

        boolean response = underTest.isValidSudoku(board);

        Assert.notNull(response, "Response can not be null");
        Assert.isTrue(response, "Response must be true");
    }

    @Test
    public void testInvalidRowBoard(){
        givenBoard(INVALID_ROW_BOARD);

        boolean response = underTest.isValidSudoku(board);

        Assert.notNull(response, "Response can not be null");
        Assert.isTrue(!response, "Response must be false");
    }

    @Test
    public void testInvalidColumnBoard(){
        givenBoard(INVALID_COLUMN_BOARD);

        boolean response = underTest.isValidSudoku(board);

        Assert.notNull(response, "Response can not be null");
        Assert.isTrue(!response, "Response must be false");
    }

    @Test
    public void testInvalidBoxBoard1(){
        givenBoard(INVALID_BOX_BOARD_1);

        boolean response = underTest.isValidSudoku(board);

        Assert.notNull(response, "Response can not be null");
        Assert.isTrue(!response, "Response must be false");
    }

    @Test
    public void testInvalidBoxBoard2(){
        givenBoard(INVALID_BOX_BOARD_2);

        boolean response = underTest.isValidSudoku(board);

        Assert.notNull(response, "Response can not be null");
        Assert.isTrue(!response, "Response must be false");
    }

    @Test
    public void testInvalidBoxBoard3(){
        givenBoard(INVALID_BOX_BOARD_3);

        boolean response = underTest.isValidSudoku(board);

        Assert.notNull(response, "Response can not be null");
        Assert.isTrue(!response, "Response must be false");
    }

    @Test
    public void testInvalidBoxBoard4(){
        givenBoard(INVALID_BOX_BOARD_4);

        boolean response = underTest.isValidSudoku(board);

        Assert.notNull(response, "Response can not be null");
        Assert.isTrue(!response, "Response must be false");
    }

    @Test
    public void testInvalidBoxBoard5(){
        givenBoard(INVALID_BOX_BOARD_5);

        boolean response = underTest.isValidSudoku(board);

        Assert.notNull(response, "Response can not be null");
        Assert.isTrue(!response, "Response must be false");
    }

    @Test
    public void testInvalidBoxBoard6(){
        givenBoard(INVALID_BOX_BOARD_6);

        boolean response = underTest.isValidSudoku(board);

        Assert.notNull(response, "Response can not be null");
        Assert.isTrue(!response, "Response must be false");
    }

    @Test
    public void testInvalidBoxBoard7(){
        givenBoard(INVALID_BOX_BOARD_7);

        boolean response = underTest.isValidSudoku(board);

        Assert.notNull(response, "Response can not be null");
        Assert.isTrue(!response, "Response must be false");
    }

    @Test
    public void testInvalidBoxBoard8(){
        givenBoard(INVALID_BOX_BOARD_8);

        boolean response = underTest.isValidSudoku(board);

        Assert.notNull(response, "Response can not be null");
        Assert.isTrue(!response, "Response must be false");
    }

    @Test
    public void testInvalidBoxBoard9(){
        givenBoard(INVALID_BOX_BOARD_9);

        boolean response = underTest.isValidSudoku(board);

        Assert.notNull(response, "Response can not be null");
        Assert.isTrue(!response, "Response must be false");
    }

    private void givenBoard(char[][] board){
        this.board = board;
    }

    private void givenSudokuValidator(char emptyCell, int boxSize){
        underTest = new SudokuValidator(emptyCell, boxSize);
    }
}
