package uk.co.streefland.rhys.oddsandsods;

/**
 * Created by Rhys on 21/10/2016.
 */
public class PostOrder {

    private static String[] array = {"1","2","3","4","5","6","7"};

    public static void main(String[] args) {
        postOrder(0);
    }

    public static void postOrder(int node) {

        if (node >= array.length) return;

        if (array[node] == null) {
            return;
        }

        postOrder(2*node+1);
        postOrder(2*node+2);
        System.out.println(array[node]);
    }
}
