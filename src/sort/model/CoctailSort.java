package sort.model;

/**
 *
 * @author Milán
 */
public class CoctailSort extends Sort {

    private int lastI1;
    private int lastI2;
    private int lastJ1;
    private int lastJ2;
    private boolean swapped;

    public CoctailSort(int[] numbers) {
        super(numbers);
        lastJ1 = 0;
        lastJ2 = numbers.length - 2;
        lastI1 = lastJ1;
        lastI2 = lastJ2;
        swapped = true;
    }

    @Override
    public void sortStep() {
        if (swapped) {
            if (lastJ1 == lastJ2) {
                swapped = false;
            } else if (lastI1 < lastJ2) {
                if (compare(lastI1, lastI1 + 1)) {
                    replace(lastI1, lastI1 + 1);
                    swapped = true;
                }
                lastI1++;
            } else if (lastI2 >= lastJ1) {
                if (compare(lastI2, lastI2 + 1)) {
                    replace(lastI2, lastI2 + 1);
                    swapped = true;
                }
                lastI2--;
            } else {
                lastJ1++;
                lastJ2--;
                lastI1 = lastJ1;
                lastI2 = lastJ2;
            }
        }
    }

    @Override
    public void sortMe() {
        do {
            swapped = false;
            for (int i = 0; i <= sorted.length - 2; i++) {
                if (compare(i, i + 1)) {
                    replace(i, i + 1);
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
            swapped = false;
            for (int i = sorted.length - 2; i >= 0; i--) {
                if (compare(i, i + 1)) {
                    replace(i, i + 1);
                    swapped = true;
                }
            }
        } while (swapped);
    }
}
