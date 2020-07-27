package exercise.game.validator.service;

import exercise.game.validator.service.sudoku.BoxesValidator;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

public class BoxesValidatorTest {
    private BoxesValidator<Character> underTest;

    @Test
    public void testDuplicatedInSameBox(){
        givenBoxesValidator(3, 9);
        Assert.isTrue(underTest.validate('1', 0), "Validation must be true");
        Assert.isTrue(!underTest.validate('1', 1), "Validation must be false");
    }

    @Test
    public void testDuplicatedInSameBox2(){
        givenBoxesValidator(3, 9);
        Assert.isTrue(underTest.validate('1', 0), "Validation must be true");
        Assert.isTrue(!underTest.validate('1', 2), "Validation must be false");
    }

    @Test
    public void testDuplicatedOnDifferentBox(){
        givenBoxesValidator(3, 9);
        Assert.isTrue(underTest.validate('1', 0), "Validation must be true");
        Assert.isTrue(underTest.validate('1', 4), "Validation must be true");
    }

    @Test
    public void testDuplicatedOnDifferentBox2(){
        givenBoxesValidator(3, 9);
        Assert.isTrue(underTest.validate('1', 0), "Validation must be true");
        Assert.isTrue(underTest.validate('1', 8), "Validation must be true");
    }

    private void givenBoxesValidator(int boxSize, int boardSize){
        underTest = new BoxesValidator<>(boxSize, boardSize);
    }
}
