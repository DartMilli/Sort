package sort.model;

/**
 *
 * @author Milán
 */
public class BubbleSort extends Sort {

    private int lastI;
    private int lastJ;

    public BubbleSort(int[] numbers) {
        super(numbers);
        lastI = numbers.length;
        lastJ = 0;
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

    @Override
    public void sortStep() {
        if (lastI > 0) {
            if (lastJ < lastI) {
                if (compare(lastJ, lastJ + 1)) {
                    replace(lastJ, lastJ + 1);
                }
                ++lastJ;
            } else {
                lastJ = 0;
                --lastI;
            }
        }
    }
}
