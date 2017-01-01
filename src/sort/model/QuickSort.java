package sort.model;

/**
 *
 * @author Milán
 */
public class QuickSort extends Sort {

    private int left;
    private int right;
    private int lastIndex;
    private int lastLeft;
    private int lastRight;
    private int lastPivot;
    private int lastI;
    private int lastJ;

    public QuickSort(int[] numbers) {
        super(numbers);
        left = 0;
        right = sorted.length - 1;
        lastPivot = sorted[(left + right) / 2];
        lastI = left;
        lastJ = right;
        lastLeft = left;
        lastRight = right;
    }

    @Override
    public void sortStep() {
        lastPivot = sorted[(left + right) / 2];
        if (lastI > lastJ) {
            lastI = left;
            lastJ = right;
            if (compare(lastIndex - 1, left)) {
                right = lastIndex - 1;
            } else if (compare(right, lastIndex)) {
                left = lastIndex;
            }
        } else {
            while (sorted[lastI] < lastPivot) {
                lastI++;
            }
            while (sorted[lastJ] > lastPivot) {
                lastJ--;
            }
            if (lastI <= lastJ) {
                replace(lastI, lastJ);
                lastI++;
                lastJ--;
            }
            lastIndex = lastI;
        }

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
                i++;
            }
            while (sorted[j] > pivot) {
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
