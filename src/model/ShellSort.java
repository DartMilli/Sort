package model;

/**
 *
 * @author Milán
 */
public class ShellSort extends Sort {

    public ShellSort(int[] numbers) {
        super(numbers);
    }

    @Override
    public void sortMe() {
        int inner, outer;
        int temp;

        int h = 1;
        while (h <= sorted.length / 3) {
            h = h * 3 + 1;
        }
        while (h > 0) {
            for (outer = h; outer < sorted.length; outer++) {
                temp = sorted[outer];
                inner = outer;

                while (inner > h - 1 && sorted[inner - h] >= temp) {
                    compareIndexToNumber(inner - h, temp);
                    replace(inner, inner - h);
                    inner -= h;
                }
                sorted[inner] = temp;
                increaseReplacement();
            }
            h = (h - 1) / 3;
        }
    }
}
