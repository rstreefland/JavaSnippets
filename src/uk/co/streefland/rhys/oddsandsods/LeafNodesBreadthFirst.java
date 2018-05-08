package uk.co.streefland.rhys.oddsandsods;

import java.util.ArrayList;

/**
 * Created by Rhys on 21/10/2016.
 */
public class LeafNodesBreadthFirst {

    public static void main(String[] args) {
        int[] array = {10, 6, 18, 4, 8, 15 , 21, -1, -1 , -1 , 14, 13, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 1, -1, -1, -1, -1, -1, -1, -1};

        ArrayList<Integer> leafNodes = new ArrayList();

        for (int i=0; i < array.length; i++) {

            if (2*i+1 >= array.length && 2*i+2 >= array.length) {
                if (array[i] != -1) {
                    leafNodes.add(array[i]);
                }
            } else {
                if (array[2*i+1] == -1 && array[2*i+2] == -1 && array[i] != -1) {
                    leafNodes.add(array[i]);
                }
            }
        }

        for (Integer leaf : leafNodes) {
            System.out.println(leaf);
        }
    }
}
