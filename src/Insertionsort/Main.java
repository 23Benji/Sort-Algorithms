package Insertionsort;

public class Main {
    public static void main(String[] args) {
        int[] array = {4, 3, 2, 1};

        System.out.println("Given Array: [" + arrayToString(array) + "]\n");

        insertionSort(array);

        System.out.println("Array sorted successfully\n");
        System.out.println("Output Array: [" + arrayToString(array) + "]");
        System.exit(0);
    }

    public static void insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int current = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > current) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = current;
        }
    }

    public static String arrayToString(int[] array) {
        StringBuilder output = new StringBuilder();
        for (int i : array) {
            output.append(i).append(" ");
        }
        return output.toString().trim();
    }
}
