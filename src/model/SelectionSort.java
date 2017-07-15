package model;

/**
 *
 * @author Milán
 */
public class SelectionSort extends Sort {

    public SelectionSort(int[] numbers) {
        super(numbers);
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
