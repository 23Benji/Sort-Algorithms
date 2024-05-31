public class Main {
    public static void main(String[] args) {
        int[] array = {1,6,345,347,4253735,368,52345,77,345};
        int temp;

        System.out.println("Given Array: ["+arrayToString(array)+"]\n");

        insertionSort(array);
        bubbleSort(array);
        selectionSort(array);


        System.out.println("Array sorted successfully\n");
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

    public static void insertionSort(int[] array){
        int temp;
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
        System.out.println("InsertionSort: ["+arrayToString(array)+"]");

    }

    public static void bubbleSort(int[] array){
       int temp;
        while (!isSorted(array)) {
            for (int i = 0; i < array.length - 1; i++) {

                if (array[i+1] < array[i]) {
                    temp = array[i];
                    array[i] = array[i+1];
                    array[i+1] = temp;
                }
            }
        }
        System.out.println("BubbleSort: ["+arrayToString(array)+"]");

    }


    public static void selectionSort(int[] array){
       int temp;
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
        System.out.println("SelectionSort: ["+arrayToString(array)+"]");

    }
}
