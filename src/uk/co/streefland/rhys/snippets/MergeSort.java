package uk.co.streefland.rhys.snippets;

/**
 * Created by Rhys on 26/10/2016.
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] array = {5, 1, 2, 9, 6, 1, 0, 8, 3};

        int low = 0;
        int high = array.length - 1;

        mergeSort(array, low, high);

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }

    private static void mergeSort(int[] array, int low, int high) {
        // check if low is smaller then high, if not then the array is sorted
        if (low < high) {
            // Get the index of the element which is in the middle
            int middle = low + (high - low) / 2;
            // Sort the left side of the array
            mergeSort(array, low, middle);
            // Sort the right side of the array
            mergeSort(array, middle + 1, high);
            // Combine them both
            merge(array,low, middle, high);
        }
    }

    private static void merge(int[] array, int low, int middle, int high) {

        int helper[] = new int[array.length];

        // Copy both parts into the helper array
        for (int i = low; i <= high; i++) {
            helper[i] = array[i];
        }

        int i = low;
        int j = middle + 1;
        int k = low;
        // Copy the smallest values from either the left or the right side back
        // to the original array
        while (i <= middle && j <= high) {
            if (helper[i] <= helper[j]) {
                array[k] = helper[i];
                i++;
            } else {
                array[k] = helper[j];
                j++;
            }
            k++;
        }
        // Copy the rest of the left side of the array into the target array
        while (i <= middle) {
            array[k] = helper[i];
            k++;
            i++;
        }

    }
}
