package view;

import java.awt.Dimension;
import java.awt.GraphicsEnvironment;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JPanel;
import controler.SortControler;
import controler.SortKeyListener;

/**
 *
 * @author Milán
 */
public class Window extends JFrame {

    public Window() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Dimension dmsn = new Dimension(
                GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds().getSize()
        );
        setSize(new Dimension(dmsn));

        setTitle("Sort 1.0.2");
        setLayout(null);
        setResizable(false);

        dmsn.setSize((dmsn.width - 7), (dmsn.height - 29));

        SortControler sortControler = new SortControler(dmsn);
        SortView[] view = SortControler.getView();
        addKeyListener(new SortKeyListener(view));

        for (int i = 0; i < view.length; i++) {
            add(view[i]);
        }

        setVisible(true);
    }
}
