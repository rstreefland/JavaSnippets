package uk.co.streefland.rhys.snippets;

/**
 * Created by Rhys on 26/10/2016.
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] array = {5, 1, 2, 9, 6, 1, 0, 8, 3};

        int low = 0;
        int high = array.length - 1;

        quickSort(array, low, high);

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }

    private static void quickSort(int[] array, int low, int high) {
        int i = low, j = high;
        // Get the pivot element from the middle of the list
        int pivot = array[low + (high - low) / 2];

        // Divide into two lists
        while (i <= j) {
            // If the current value from the left list is smaller than the pivot
            // element then get the next element from the left list
            while (array[i] < pivot) {
                i++;
            }
            // If the current value from the right list is larger then the pivot
            // element then get the next element from the right list
            while (array[j] > pivot) {
                j--;
            }

            // If we have found a values in the left list which is larger then
            // the pivot element and if we have found a value in the right list
            // which is smaller then the pivot element then we exchange the
            // values.
            // As we are done we can increase i and j
            if (i <= j) {
                exchange(array, i, j);
                i++;
                j--;
            }
        }
        // Recursion
        if (low < j)
            quickSort(array, low, j);
        if (i < high)
            quickSort(array,i, high);
    }

    private static void exchange(int[] array, int i, int j) {
        int temp =  array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
