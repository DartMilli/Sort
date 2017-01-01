package sort.controler;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import sort.model.*;
import sort.view.SortView;

/**
 *
 * @author Milán
 */
public class SortControler {

    private static SortView[] view;
    private static Sort[] model;
    private static int row;
    private static int column;
    private static Dimension dimension;
    private static boolean run;
    private static boolean stepByStep = false;
    private static Timer clock = new Timer(1, new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent ae) {
            for (int i = 0; i < view.length; i++) {
                if (stepByStep) {
                    view[i].getModel().sortStep();
                }
                view[i].repaint();
            }
        }

    });

    public SortControler(Dimension dmsn) {
        this.dimension = dmsn;
        int[] list = Sort.generateRandomNumbers(100);
        
        view = new SortView[8];
        model = new Sort[8];
        
        model[0] = new BubbleSort(list.clone());
        model[1] = new CoctailSort(list.clone());
        model[2] = new InsertionSort(list.clone());
        model[3] = new SelectionSort(list.clone());
        model[4] = new QuickSort(list.clone());
        model[5] = new HeapSort(list.clone());
        model[6] = new ShellSort(list.clone());
        model[7] = new MergeSort(list.clone());
        
        for (int i = 0; i < view.length; i++) {
            view[i] = new SortView(model[i]);
        }
        
        run = false;
        column = 1;
        row = view.length / column;
        setViewBounces();
    }

    public static void setViewBounces() {
        int index = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                view[index].setDimension(new Dimension(
                        dimension.width / column,
                        dimension.height / row));
                view[index].setBounds(
                        dimension.width / column * j,
                        dimension.height / row * i,
                        dimension.width / column,
                        dimension.height / row);
                index++;
            }
        }
    }

    public static SortView[] getView() {
        return view;
    }

    public static void setRowsAndColumns() {
        int pieces = view.length;
        if (column == 1) {
            column = 2;
        } else if (column == 2) {
            column = 4;
        } else if (column == 4) {
            column = 8;
        } else if (column == 8) {
            column = 1;
        }
        row = view.length / column;
    }

    public static void setRun() {
        run = !run;
    }

    public static boolean isRun() {
        return run;
    }

    public static void startSort() {
        clock.start();
        if (!stepByStep) {
            for (int i = 0; i < view.length; i++) {
                view[i].getModel().sortMe();
            }
        }
    }

    public static void stopSort() {
        clock.stop();
    }

    public static void refresh() {
        for (int i = 0; i < view.length; i++) {
            view[i].repaint();
        }
    }
}
