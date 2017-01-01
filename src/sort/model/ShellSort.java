package sort.model;

/**
 *
 * @author Milán
 */
public class ShellSort extends Sort {

    public ShellSort(int[] numbers) {
        super(numbers);
    }

    @Override
    public void sortStep() {

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
                    sorted[inner] = sorted[inner - h];
                    inner -= h;
                }
                sorted[inner] = temp;
            }
            h = (h - 1) / 3;
        }
    }

}
