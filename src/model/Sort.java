package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import view.SortView;

/**
 *
 * @author Milán
 */
public abstract class Sort implements Runnable {

    protected int[] numbers;
    protected int[] sorted;
    protected int[] comparedIndexes = new int[2];
    private long comparison;
    private long replacement;
    private SortView view;
    private static int sortSpeedInMilisecond = 40;

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

    public void setView(SortView view) {
        this.view = view;
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

    public void increaseComparison() {
        comparison++;
        try {
            TimeUnit.MILLISECONDS.sleep(sortSpeedInMilisecond);
        } catch (InterruptedException ex) {
            Logger.getLogger(Sort.class.getName()).log(Level.SEVERE, null, ex);
        }
        view.repaint();
    }

    public void increaseReplacement() {
        replacement++;
        try {
            TimeUnit.MILLISECONDS.sleep(sortSpeedInMilisecond);
        } catch (InterruptedException ex) {
            Logger.getLogger(Sort.class.getName()).log(Level.SEVERE, null, ex);
        }
        view.repaint();
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
            comparedIndexes[0] = index1;
            comparedIndexes[1] = index2;
            if (sorted[comparedIndexes[0]] > sorted[comparedIndexes[1]]) {
                comp = true;
            } else {
                comp = false;
            }
            increaseComparison();
        }
        return comp;
    }

    public boolean compareIndexToNumber(int index1, int num) {
        boolean comp = false;
        if (sortedContains(num)) {
            int index2 = getIndexInSorted(num);
            comp = compare(index1, index2);
        }
        return comp;
    }

    private boolean sortedContains(int num) {
        boolean out = false;
        int index = 0;
        while (!out && index < sorted.length) {
            if (sorted[index] == num) {
                out = true;
            }
            index++;
        }
        return out;
    }

    protected int getIndexInSorted(int num) {
        int out = 0;
        boolean contains = false;
        int index = 0;
        while (!contains && index < sorted.length) {
            if (sorted[index] == num) {
                out = index;
                contains = true;
            }
            index++;
        }
        return out;
    }

    public void replace(int index1, int index2) {
        if (sorted.length > index1 && sorted.length > index2) {
            int tmp = sorted[index1];
            sorted[index1] = sorted[index2];
            sorted[index2] = tmp;
            increaseReplacement();
        }
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

    public static int getSortSpeedInMilisecond() {
        return sortSpeedInMilisecond;
    }

    public static void setSortSpeedInMilisecond(int sortSpeedInMilisecond) {
        Sort.sortSpeedInMilisecond = sortSpeedInMilisecond;
    }

    public abstract void sortMe();

    @Override
    public void run() {
        sortMe();
    }
}
