package sort.model;

/**
 *
 * @author Milán
 */
public class SelectionSort extends Sort {

    private int lastI;
    private int lastJ;
    private int length;
    private int minimumIndex;

    public SelectionSort(int[] numbers) {
        super(numbers);
        lastI = 0;
        lastJ = 1;
        length = sorted.length;
        minimumIndex = lastI;
    }

    @Override
    public void sortStep() {
        if (lastI < length - 1) {
            if (lastJ < length) {
                if (compare(minimumIndex, lastJ)) {
                    minimumIndex = lastJ;
                }
                lastJ++;
            } else {
                lastJ = lastI + 1;
                if (minimumIndex != lastI) {
                    replace(lastI, minimumIndex);
                }                
                lastI++;
                minimumIndex = lastI;
            }
        }
    }

    @Override
    public void sortMe() {
        int i, j, minIndex;
        int n = sorted.length;
        for (i = 0; i < n - 1; i++) {
            minIndex = i;
            for (j = i + 1; j < n; j++) {
                if (compare(minIndex, j)) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                replace(i, minIndex);
            }
        }
    }

}
