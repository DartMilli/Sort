package model;

/**
 *
 * @author Milán
 */
public class InsertionSort extends Sort {

    public InsertionSort(int[] numbers) {
        super(numbers);
    }

    @Override
    public void sortMe() {
        int i, j, newValue;
        for (i = 1; i < sorted.length; i++) {
            newValue = sorted[i];
            j = i;
            while (j > 0 && sorted[j - 1] > newValue) {
                compareIndexToNumber(j-1, newValue);
                replace(j, j - 1);
                j--;
            }
            increaseReplacement();
            sorted[j] = newValue;
        }
    }
}
