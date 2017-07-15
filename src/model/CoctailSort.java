package model;

/**
 *
 * @author Milán
 */
public class CoctailSort extends Sort {

    public CoctailSort(int[] numbers) {
        super(numbers);
        
    }
    
    @Override
    public void sortMe() {
        boolean swapped;
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
