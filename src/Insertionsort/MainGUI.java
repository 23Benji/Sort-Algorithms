package Insertionsort;

import javax.swing.*;
import java.awt.*;
import java.util.Random;


public class MainGUI {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(MainGUI::createAndShowGUI);
    }

    private static void createAndShowGUI() {
        Random random = new Random();
        JFrame frame = new JFrame("Selection Sort Visualization");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        int WIDTH = 2800;
        int HEIGHT = 1800;
        frame.setSize(WIDTH, HEIGHT);
        frame.setLocation(-7,-5);

        int[] array= new int[144];
        for(int i = 0;i<144;i++){
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
            g.setColor(new Color(148, 4, 4, 255));
            g.fillRect(i * BAR_WIDTH, getHeight() - array[i] * BAR_HEIGHT_MULTIPLIER, BAR_WIDTH, array[i] * BAR_HEIGHT_MULTIPLIER);
            g.setColor(new Color(255, 0, 0, 124));
            g.drawRect(i * BAR_WIDTH, getHeight() - array[i] * BAR_HEIGHT_MULTIPLIER, BAR_WIDTH, array[i] * BAR_HEIGHT_MULTIPLIER);
        }
    }

    public void sort() {
        for (int i = 1; i < array.length; i++) {
            int current = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > current) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = current;

            repaint();
            try {
                Thread.sleep(50);  // Pause to visualize sorting
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}

