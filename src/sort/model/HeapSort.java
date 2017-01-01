package sort.model;

/**
 *
 * @author Milán
 */
public class HeapSort extends Sort {

    private int N;

    public HeapSort(int[] numbers) {
        super(numbers);
    }

    @Override
    public void sortStep() {

    }

    @Override
    public void sortMe() {
        heapify();
        for (int i = N; i > 0; i--) {
            replace(0, i);
            N = N - 1;
            maxheap(0);
        }
    }

    /* Function to build a heap */
    public void heapify() {
        N = sorted.length - 1;
        for (int i = N / 2; i >= 0; i--) {
            maxheap(i);
        }
    }

    /* Function to swap largest element in heap */
    public void maxheap(int i) {
        int left = 2 * i;
        int right = 2 * i + 1;
        int max = i;
        if (left <= N && sorted[left] > sorted[i]) {
            compare(left, i);
            max = left;
        }
        if (right <= N && sorted[right] > sorted[max]) {
            compare(right, i);
            max = right;
        }

        if (max != i) {
            replace(i, max);
            maxheap(max);
        }
    }

}
