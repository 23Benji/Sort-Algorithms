package Bubblesort;

public class Main {
    public static void main(String[] args) {
        int[] array = {1,7,4,9,3,45,876,23,765,346,0,548,956,354};
        int temp;

        System.out.println("Given Array: ["+arrayToString(array)+"]\n");

        while (!isSorted(array)) {
            for (int i = 0; i < array.length - 1; i++) {

                if (array[i+1] < array[i]) {
                    temp = array[i];
                    array[i] = array[i+1];
                    array[i+1] = temp;
                }
            }
        }
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
