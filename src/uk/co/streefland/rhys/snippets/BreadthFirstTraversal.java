package uk.co.streefland.rhys.snippets;

import java.util.*;

/**
 * Created by Rhys on 23/10/2016.
 */
public class BreadthFirstTraversal {

    private static Queue<Integer> queue = new LinkedList<>();

    public static void main(String[] args) {
        int startNode = 0;

        int[][] matrix =
                {{0, 1, 1, 0, 0, 0, 0},
                {1, 0, 0, 1, 1, 1, 0},
                {1, 0, 0, 0, 0, 0, 1},
                {0, 1, 0, 0, 0, 0, 1},
                {0, 1, 0, 0, 0, 0, 1},
                {0, 1, 0, 0, 0, 0 ,0},
                {0, 0, 1, 1, 1, 0, 0}};

        int[] visited = new int[matrix.length];

        findAdjacentNodes(matrix, visited, startNode);
        visited[startNode] = 1;
        System.out.println("Explored:" + startNode);

        while(!queue.isEmpty()) {
            int toExplore = queue.remove();
            findAdjacentNodes(matrix, visited, toExplore);
            System.out.println("Explored:" + toExplore);
        }
    }

    public static void findAdjacentNodes(int[][] matrix, int[] visited, int node) {

        for (int i=0; i < matrix.length; i++) {
            if (matrix[node][i] == 1 && visited[i] == 0) {
                queue.add(i);
                visited[i] = 1;
            }
        }
    }
}
