package Selectionsort;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class MainGUI {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(Selectionsort.MainGUI::createAndShowGUI);
    }

    private static void createAndShowGUI() {
        Random random = new Random();
        JFrame frame = new JFrame("Selection Sort Visualization");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        int WIDTH = 2800;
        int HEIGHT = 1800;
        frame.setSize(WIDTH, HEIGHT);
        frame.setLocation(-7,-5);
        int[] array = new int[144];
        for (int i = 0; i < 144; i++) {
            array[i] = random.nextInt(150);
        }

        SortingPanel sortingPanel = new SortingPanel(array);
        frame.add(sortingPanel);
        frame.setVisible(true);

        new Thread(sortingPanel::sort).start();
    }
}

class SortingPanel extends JPanel {
    private int[] array;
    private boolean[] sorted;
    private static final int BAR_WIDTH = 10;
    private static final int BAR_HEIGHT_MULTIPLIER = 5;

    public SortingPanel(int[] array) {
        this.array = array;
        this.sorted = new boolean[array.length];
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.black);
        g.fillRect(0, 0, 2800, 1800);
        for (int i = 0; i < array.length; i++) {
            if (sorted[i]) {
                g.setColor(new Color(14, 148, 4, 255));
                g.fillRect(i * BAR_WIDTH, getHeight() - array[i] * BAR_HEIGHT_MULTIPLIER, BAR_WIDTH, array[i] * BAR_HEIGHT_MULTIPLIER);
                g.setColor(new Color(55, 255, 0, 124));
                g.drawRect(i * BAR_WIDTH, getHeight() - array[i] * BAR_HEIGHT_MULTIPLIER, BAR_WIDTH, array[i] * BAR_HEIGHT_MULTIPLIER);
            } else {
                g.setColor(new Color(148, 4, 4, 255));
                g.fillRect(i * BAR_WIDTH, getHeight() - array[i] * BAR_HEIGHT_MULTIPLIER, BAR_WIDTH, array[i] * BAR_HEIGHT_MULTIPLIER);
                g.setColor(new Color(255, 0, 0, 124));
                g.drawRect(i * BAR_WIDTH, getHeight() - array[i] * BAR_HEIGHT_MULTIPLIER, BAR_WIDTH, array[i] * BAR_HEIGHT_MULTIPLIER);

            }
        }
    }

    public void sort() {
        int temp;
        for (int i = 0; i < array.length - 1; i++) {
            int low = i;

            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[low]) {
                    low = j;
                }
            }

            temp = array[i];
            array[i] = array[low];
            array[low] = temp;

            sorted[i] = true;
            repaint();
            try {
                Thread.sleep(50);  // Pause to visualize sorting
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        sorted[array.length - 1] = true;  // Ensure the last element is marked as sorted
        repaint();
    }
}
