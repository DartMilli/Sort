package sort.controler;

import sort.view.Window;

/**
 *
 * @author Milán
 */
public class SortRunner {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Window();
            }
        });
    }
    
}
