package uk.co.streefland.rhys.snippets;

import java.util.Stack;

/**
 * Created by Rhys on 21/10/2016.
 */
public class InOrder {

    private static String[] array = {"1","2","3","4","5","6","7"};

    public static void main(String[] args) {
        Stack<Integer> toExplore = new Stack<>();

        inOrder(0);
    }

    public static void inOrder(int node) {

        if (node >= array.length) {
            return;
        }

        if (array[node] == null) {
            return;
        }

        inOrder(2*node+1);
        System.out.println(array[node]);
        inOrder(2*node+2);
    }
}
