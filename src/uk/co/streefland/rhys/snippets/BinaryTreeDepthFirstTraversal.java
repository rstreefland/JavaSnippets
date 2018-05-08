package uk.co.streefland.rhys.snippets;

import java.util.Stack;

/**
 * Created by Rhys on 21/10/2016.
 */
public class BinaryTreeDepthFirstTraversal {

    public static void main(String[] args) {
        int toFind = 13;
        int[] array = {10, 6, 18, 4, 8, 15, 21, -1, -1, -1, 14, 13, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 1, -1, -1, -1, -1, -1, -1, -1};

        Stack<Integer> toExplore = new Stack<>();

        int root = 0;

        System.out.println("Explored: " + array[root]);

        do {
            int left = 2 * root + 1;
            int right = 2 * root + 2;

            if (toExplore.size() > 0) {
                root = toExplore.pop();
                System.out.println("Explored: " + array[root]);
                left = 2 * root + 1;
                right = 2 * root + 2;
            }


            if (left < array.length && right < array.length) {
                if (array[right] != -1) {
                    toExplore.push(right);
                }

                if (array[left] != -1) {
                    toExplore.push(left);
                }
            }
        } while (toExplore.size() > 0);

    }
}
