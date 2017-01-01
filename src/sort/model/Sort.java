package sort.model;

import java.util.ArrayList;
import java.util.Collections;
import sort.controler.SortControler;

/**
 *
 * @author Milán
 */
public abstract class Sort {

    protected int[] numbers;
    protected int[] sorted;
    protected long comparison;
    protected long replacement;
    protected int[] comparedIndexes = new int[2];

    public Sort(int[] numbers) {
        this.numbers = numbers;
        this.sorted = numbers;
        comparison = 0;
        replacement = 0;
    }

    public Sort() {
        numbers = new int[0];
        sorted = new int[0];
        comparison = 0;
        replacement = 0;
    }

    public int[] getNumbers() {
        return numbers;
    }

    public void setNumbers(int[] numbers) {
        this.numbers = numbers;
        this.sorted = numbers;
    }

    public int[] getSorted() {
        return sorted;
    }

    public long getComparison() {
        return comparison;
    }

    public long getReplacement() {
        return replacement;
    }

    public int[] getComparedIndexes() {
        return comparedIndexes;
    }

    public boolean isSorted() {
        boolean isSorted = false;
        for (int i = 1; i < sorted.length; i++) {
            if (compare(i - 1, i)) {
                isSorted = true;
            } else {
                isSorted = false;
            }
        }
        return isSorted;
    }

    public boolean compare(int index1, int index2) {
        boolean comp = false;
        if (sorted.length > index1 && sorted.length > index2) {
            comparison++;
            comparedIndexes[0] = index1;
            comparedIndexes[1] = index2;
            if (sorted[index1] > sorted[index2]) {
                comp = true;
            } else {
                comp = false;
            }
        }
        SortControler.refresh();
        return comp;
    }

    public void replace(int index1, int index2) {
        if (sorted.length > index1 && sorted.length > index2) {
            replacement++;
            int tmp = sorted[index1];
            sorted[index1] = sorted[index2];
            sorted[index2] = tmp;
        }
        SortControler.refresh();
    }

    public static int[] generateRandomNumbers(int pieces) {
        int[] out = new int[pieces];
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < pieces; i++) {
            list.add(i);
        }
        Collections.shuffle(list);
        for (int i = 0; i < pieces; i++) {
            out[i] = list.get(i);
        }
        return out;
    }

    public abstract void sortStep();

    public abstract void sortMe();
}
