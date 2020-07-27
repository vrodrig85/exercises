package exercise.game.validator.service;

public interface GameValidator <T> {
    boolean isValidSudoku(final T board);
}
