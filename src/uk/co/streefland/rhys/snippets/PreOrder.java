package uk.co.streefland.rhys.snippets;

/**
 * Created by Rhys on 21/10/2016.
 */
public class PreOrder {
    private static String[] array = {"1","2","3","4","5","6","7"};

    public static void main(String[] args) {
        preOrder(0);
    }

    public static void preOrder(int node) {

        if (node >= array.length) return;

        if (array[node] == null) {
            return;
        }

        System.out.println(array[node]);
        preOrder(2*node+1);
        preOrder(2*node+2);
    }
}
