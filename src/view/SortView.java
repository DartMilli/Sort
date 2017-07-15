package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JPanel;
import model.Sort;

/**
 *
 * @author Milán
 */
public class SortView extends JPanel {

    private boolean lines;
    private int thickness;
    private Dimension dimension;
    private Sort model;

    public SortView(Sort sort) {
        this.model = sort;
        lines = true;
        thickness = 1;
    }

    public Sort getModel() {
        return model;
    }

    public boolean isLines() {
        return lines;
    }

    public void setLines() {
        lines = !lines;
    }

    public int getThickness() {
        return thickness;
    }

    public void setThickness(int thickness) {
        this.thickness = thickness;
    }

    public void increaseThickness() {
        thickness++;
    }

    public void decreaseThickness() {
        if (thickness > 1) {
            thickness--;
        }
    }

    public void setDimension(Dimension dmsn) {
        this.dimension = dmsn;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, dimension.width, dimension.height);

        double x, y;
        int[] comparedOnes = model.getComparedIndexes();
        int[] sortedArray = model.getSorted();
        for (int i = 0; i < sortedArray.length; i++) {
            int dotThickness;
            if (comparedOnes[0] == i || comparedOnes[1] == i) {
                g.setColor(Color.RED);
                if (thickness < 3) {
                    dotThickness = 4 * thickness;
                } else {
                    dotThickness = 2 * thickness;
                }
            } else {
                dotThickness = 2 * thickness;
                g.setColor(Color.WHITE);
            }
            x = (dimension.getWidth()) / sortedArray.length * i;
            y = (dimension.getHeight()) / sortedArray.length * sortedArray[i];
            if (lines) {
                g.fillRect((int) x, (int) y, thickness, dimension.height - (int) y);
            } else {
                g.fillOval((int) x, (int) y, dotThickness, dotThickness);
            }
        }

        g.setFont(new Font("Courier New", Font.BOLD, 20));
        g.setColor(new Color(100, 100, 100));
        //int fontWith = g.getFontMetrics().stringWidth(model.getClass().getSimpleName());
        int fontWith = g.getFontMetrics().stringWidth("SelectionSort");
        g.drawString(model.getClass().getSimpleName(), dimension.width - fontWith - 5, 20);
        g.setFont(new Font("Courier New", Font.BOLD, 12));
        g.drawString("comparison:  " + model.getComparison(), dimension.width - fontWith - 5, 30);
        g.drawString("replacement: " + model.getReplacement(), dimension.width - fontWith - 5, 40);
        
        g.setColor(Color.YELLOW);
        g.drawRect(0, 0, dimension.width, dimension.height);
    }

}
