package uk.co.streefland.rhys.snippets;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Rhys on 21/10/2016.
 */
public class BinaryTreeBreadthFirstTraversal {

    public static void main(String[] args) {
        int toFind = 13;
        int[] array = {10, 6, 18, 4, 8, 15, 21, -1, -1, -1, 14, 13, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 1, -1, -1, -1, -1, -1, -1, -1};

        Queue<Integer> toExplore = new LinkedList<>();

        int root = 0;

        do {
            if (toExplore.size() > 0) {
                root = toExplore.poll();
            }

            int left = 2 * root + 1;
            int right = 2 * root + 2;

            if (left < array.length && right < array.length) {

                if (array[left] != -1) {
                    toExplore.add(left);
                    System.out.println("Added: " + array[left]);
                }

                if (array[right] != -1) {
                    toExplore.add(right);
                    System.out.println("Added: " + array[right]);
                }
            }

        } while (toExplore.size() > 0);

    }
}
