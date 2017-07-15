package model;

/**
 *
 * @author Milán
 */
public class QuickSort extends Sort {

    private int left;
    private int right;

    public QuickSort(int[] numbers) {
        super(numbers);
        left = 0;
        right = sorted.length - 1;
    }

    @Override
    public void sortMe() {
        quickSort(left, right);
    }

    private void quickSort(int left, int right) {
        int index = partition(left, right);
        if (left < index - 1) {
            compare(index - 1, left);
            quickSort(left, index - 1);
        }
        if (index < right) {
            compare(right, index);
            quickSort(index, right);
        }
    }

    private int partition(int left, int right) {
        int i = left, j = right;
        int pivot = sorted[(left + right) / 2];
        while (i <= j) {
            while (sorted[i] < pivot) {
                compareIndexToNumber(i, pivot);
                i++;
            }
            while (sorted[j] > pivot) {
                compareIndexToNumber(j, pivot);
                j--;
            }
            if (i <= j) {
                replace(i, j);
                i++;
                j--;
            }
        };
        return i;
    }

}
