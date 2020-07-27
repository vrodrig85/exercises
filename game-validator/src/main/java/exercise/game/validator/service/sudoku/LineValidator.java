package exercise.game.validator.service.sudoku;

import java.util.HashSet;
import java.util.Set;

/**
 * Validates duplicated element on a sets on lines, each line is identified by his index
 *
 * @param <T> type of elements in the lines
 */
public class LineValidator<T> {
    private Set<T>[] line;

    /**
     * Constructor
     * @param amountOfLines amount of lines to be validated
     */
    public LineValidator(final int amountOfLines) {
        this.line = new HashSet[amountOfLines];
        initializeLine(amountOfLines);
    }

    /**
     * Validates if elements on line identified by line index.
     * @param element element to be validated
     * @param lineIndex identifier of the line
     * @return true if is valid
     */
    public boolean validate(final T element, final int lineIndex) {
        if (!line[lineIndex].add(element)) {
            return false;
        }
        return true;
    }

    /**
     * Initializes lines sets
     *
     * @param amountOfLines amount of lines to be initializes
     */
    private void initializeLine(int amountOfLines) {
        for (int i = 0; i < amountOfLines; i++) {
            line[i] = new HashSet();
        }
    }
}
