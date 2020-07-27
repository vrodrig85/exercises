package exercise.game.validator.service;

import exercise.game.validator.service.sudoku.LineValidator;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

public class LineValidatorTest {
    private LineValidator<Character> underTest;
    private char[] validLine = {'1', '2', '3', '4', '5'};

    @Test
    public void testValidLine(){
        givenLineValidator(5);

        for(int i =0; i<5; i++){
            Assert.isTrue(underTest.validate(validLine[i], i), "Validation must be true");
        }
    }

    @Test
    public void testInvalidLine(){
        givenLineValidator(1);

        //adding same element to same line
        Assert.isTrue(underTest.validate('1', 0), "Validation must be true");
        Assert.isTrue(!underTest.validate('1', 0), "Validation must be false");
    }

    private void givenLineValidator(int size){
        underTest = new LineValidator<>(size);
    }
}
