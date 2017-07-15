package model;

/**
 *
 * @author Milán
 */
public class BubbleSort extends Sort {

    public BubbleSort(int[] numbers) {
        super(numbers);
    }

    @Override
    public void sortMe() {
        for (int i = sorted.length; 0 < i; --i) {
            for (int j = 0; j < i; ++j) {
                if (compare(j, j + 1)) {
                    replace(j, j + 1);
                }
            }
        }
    }
}
