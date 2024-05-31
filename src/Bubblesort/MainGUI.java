
package Bubblesort;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

import static Bubblesort.Main.isSorted;

public class MainGUI {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(Bubblesort.MainGUI::createAndShowGUI);
    }

    private static void createAndShowGUI() {
        Random random = new Random();
        JFrame frame = new JFrame("Selection Sort Visualization");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        int WIDTH = 2800;
        int HEIGHT = 1800;
        frame.setSize(WIDTH, HEIGHT);
        frame.setLocation(-7,-5);

        int[] array= new int[140];
        for(int i = 0;i<140;i++){
            array[i]= random.nextInt(150);
        }

        SortingPanel sortingPanel = new SortingPanel(array);
        frame.add(sortingPanel);
        frame.setVisible(true);

        new Thread(sortingPanel::sort).start();
    }
}

class SortingPanel extends JPanel {
    private int[] array;
    private static final int BAR_WIDTH = 10;
    private static final int BAR_HEIGHT_MULTIPLIER = 5;

    public SortingPanel(int[] array) {
        this.array = array;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.black);
        g.fillRect(0,0,2800,1800);
        g.setColor(Color.WHITE);
        for (int i = 0; i < array.length; i++) {
            g.setColor(Color.WHITE);
            g.fillRect(i * BAR_WIDTH, getHeight() - array[i] * BAR_HEIGHT_MULTIPLIER, BAR_WIDTH, array[i] * BAR_HEIGHT_MULTIPLIER);
            g.setColor(Color.gray);
            g.drawRect(i * BAR_WIDTH, getHeight() - array[i] * BAR_HEIGHT_MULTIPLIER, BAR_WIDTH, array[i] * BAR_HEIGHT_MULTIPLIER);

        }
    }
    public void sort() {
        int temp;
        while (!isSorted(array)) {
            for (int i = 0; i < array.length - 1; i++) {

                if (array[i+1] < array[i]) {
                    temp = array[i];
                    array[i] = array[i+1];
                    array[i+1] = temp;
                }
                repaint();
                try {
                    Thread.sleep(50);  // Pause to visualize sorting
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        }
    }

