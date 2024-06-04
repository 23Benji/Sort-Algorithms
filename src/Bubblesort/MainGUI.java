package Bubblesort;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class MainGUI {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(Bubblesort.MainGUI::createAndShowGUI);
    }

    private static void createAndShowGUI() {
        Random random = new Random();
        JFrame frame = new JFrame("Bubble Sort Visualization");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        int WIDTH = 2800;
        int HEIGHT = 1800;
        frame.setSize(WIDTH, HEIGHT);
        frame.setLocation(-7, -5);

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
        int n = array.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    // Swap array[j] and array[j+1]
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swapped = true;
                }
                repaint();
                try {
                    Thread.sleep(10);  // Pause to visualize sorting
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            // Mark the last i elements as sorted
            sorted[n - 1 - i] = true;
            repaint();
            try {
                Thread.sleep(10);  // Pause to visualize the sorted part
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (!swapped) break;  // Array is sorted
        }
        // Ensure all elements are marked as sorted
        for (int i = 0; i < n; i++) {
            sorted[i] = true;
            repaint();
            try {
                Thread.sleep(10);  // Slight delay to visualize the final sorting
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
