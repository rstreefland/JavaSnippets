package uk.co.streefland.rhys.oddsandsods;

/**
 * Created by Rhys on 31/10/2016.
 */
public class BubbleSort {
    public static void main(String[] args) {

        int[] array = {5, 1, 2, 9, 6, 1, 0, 8, 3};

        for (int i=0; i < array.length - 1; i++) {
            for (int j=0; j < array.length - 1; j++) {
                if (array[j] > array[j+1]) {
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }


        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }
}
