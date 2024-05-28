package Selectionsort;

public class Main {
    public static void main(String[] args) {
        int[] array = {5, 6, 7, 8, 3, 4, 5, 1, 20};
        int temp;

        System.out.println("Given Array: ["+arrayToString(array)+"]");

        if (isSorted(array)) {

        }

        for (int i = 0; i < array.length - 1; i++) {
            int low = i;  // Initialize `low` to the current position

            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[low]) {
                    low = j;
                }
            }

            // Swap elements
            temp = array[i];
            array[i] = array[low];
            array[low] = temp;
        }
        System.out.println();
        System.out.println("Array sorted successfully\n");
        System.out.println("OutputArray: ["+arrayToString(array)+"]");
        System.exit(0);
    }


    public static boolean isSorted(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                return false;
            }
        }
        return true;
    }

    public static String arrayToString(int[] array) {
        StringBuilder output = new StringBuilder();
        for (int i : array) {
            output.append(i).append(" ");
        }
        return output.toString().trim();
    }
}
