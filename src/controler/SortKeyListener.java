package controler;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import model.Sort;
import view.SortView;

/**
 *
 * @author Milán
 */
public class SortKeyListener implements KeyListener {

    private SortView[] view;

    public SortKeyListener(SortView view[]) {
        this.view = view;
    }

    @Override
    public void keyTyped(KeyEvent ke) {
        char key = ke.getKeyChar();
        if (key == ' ') {
            if (SortControler.isRun()) {
                SortControler.stopSort();
            } else {
                SortControler.startSort();
            }
            SortControler.setRun();
        } else if ((int) key == KeyEvent.VK_BACK_SPACE) {
            for (int i = 0; i < view.length; i++) {
                view[i].setLines();
            }
        } else if (key == 'v') {
            SortControler.setRowsAndColumns();
            SortControler.setViewBounces();
        } else if (key == 't') {
            for (int i = 0; i < view.length; i++) {
                view[i].increaseThickness();
            }
        } else if (key == 'T') {
            for (int i = 0; i < view.length; i++) {
                view[i].decreaseThickness();
            }
        } else if (key == 's') {
            int speed = Sort.getSortSpeedInMilisecond();
            if (speed > 2) {
                Sort.setSortSpeedInMilisecond(speed-1);
            }
        } else if (key == 'S') {
            int speed = Sort.getSortSpeedInMilisecond()+1;
            Sort.setSortSpeedInMilisecond(speed);
        }
    }

    @Override
    public void keyPressed(KeyEvent ke) {
    }

    @Override
    public void keyReleased(KeyEvent ke) {
    }

}
