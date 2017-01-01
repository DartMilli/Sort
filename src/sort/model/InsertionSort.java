package sort.model;

/**
 *
 * @author Milán
 */
public class InsertionSort extends Sort {

    private int lastI;
    private int lastJ;
    private int newVal;

    public InsertionSort(int[] numbers) {
        super(numbers);
        lastI = 1;
        lastJ = 1;
        newVal = sorted[lastI];
    }

    @Override
    public void sortStep() {
        if (lastI < sorted.length) {
            if (lastJ > 0 && sorted[lastJ - 1] > newVal) {
                compare(lastJ - 1, lastI);
                replace(lastJ, lastJ - 1);
                lastJ--;
            } else {
                lastI++;
                if (lastI < sorted.length) {
                    sorted[lastJ] = newVal;
                    newVal = sorted[lastI];
                    lastJ = lastI;
                }
            }
        }
    }

    @Override
    public void sortMe() {
        int i, j, newValue;
        for (i = 1; i < sorted.length; i++) {
            newValue = sorted[i];
            j = i;
            while (j > 0 && sorted[j - 1] > newValue) {
                sorted[j] = sorted[j - 1];
                j--;
            }
            sorted[j] = newValue;
        }
    }
}
