package exercise.game.validator.service.sudoku;

import com.google.common.collect.Range;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Stream;

/**
 * Responsible of validate that boxes in the board
 * @param <T> type of elements in the boxes
 */
public class BoxesValidator<T> {
    private Set<T>[] boxes;
    private Range[] ranges;

    /**
     * BoxesValidator constructor
     *
     * @param boxSize
     * @param boardSize
     */
    public BoxesValidator(final int boxSize, final int boardSize) {
        int boxesAmount = boardSize / boxSize;
        initializeBoxes(boardSize);
        ranges = initializeRanges(boxesAmount, boardSize);
    }

    /**
     * Validates that the element is not duplicated in the box
     *
     * @param element the element to validate
     * @param index   index in the board to identify his box
     * @return true if valid
     */
    public boolean validate(final T element, int index) {
        Optional<Set<T>> optionalBox = getBox(index);
        if (!optionalBox.isPresent()) {
            throw new IllegalStateException("Missing box, the box for element was not identified");
        } else if (!optionalBox.get().add(element)) {
            return false;
        }
        return true;
    }

    /**
     *
     *
     */
    public void resetBoxes() {
        Stream.of(boxes)
                .forEach(box -> box.clear());
    }

    private Range[] initializeRanges(final int boxesAmount,
                                     final int boardSize) {
        ranges = new Range[boxesAmount];
        int j = 0;
        for (int i = 0; i < boardSize; i += boxesAmount) {
            int rangeApper = i + boxesAmount - 1;
            ranges[j] = Range.closed(i, rangeApper);
            j++;
        }
        return ranges;
    }

    private Optional<Set<T>> getBox(final int index) {
        Optional<Set<T>> result = Optional.empty();
        for (int i = 0; i < ranges.length; i++) {
            if (ranges[i].contains(index)) {
                result = Optional.ofNullable(boxes[i]);
                break;
            }
        }
        return result;
    }

    private void initializeBoxes(int size) {
        boxes = new HashSet[size];
        for (int i = 0; i < size; i++) {
            boxes[i] = new HashSet();
        }
    }
}
