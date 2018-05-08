package uk.co.streefland.rhys.oddsandsods;

import java.util.*;

/**
 * Created by Rhys on 23/10/2016.
 */
public class DepthFirstTraversal {

    private static Stack<Integer> stack = new Stack();

    public static void main(String[] args) {
        int startNode = 0;

        int[][] matrix =
                        {{0, 1, 1, 0, 0, 0, 0},
                        {1, 0, 0, 1, 1, 1, 0},
                        {1, 0, 0, 0, 0, 0, 1},
                        {0, 1, 0, 0, 0, 0, 1},
                        {0, 1, 0, 0, 0, 0, 1},
                        {0, 1, 0, 0, 0, 0, 0},
                        {0, 0, 1, 1, 1, 0, 0}};

        int[] visited = new int[matrix.length];
        int[] explored = new int[matrix.length];

        stack.push(startNode);
        visited[startNode] = 1;

        while (!stack.isEmpty()) {
            int toExplore = stack.pop();
            findAdjacentNodes(matrix, visited, explored, toExplore);
            //System.out.println("Visited: " + toVisit);
        }
    }

    public static void findAdjacentNodes(int[][] matrix, int[] visited, int[] explored, int node) {

        for (int i = 0; i < matrix.length; i++) {
            if (matrix[node][i] == 1 && visited[i] == 0 && explored[i] == 0) {
                stack.push(i);
                visited[i] = 1;
                System.out.println("Visited " + i);
            }
        }

        explored[node] = 1;
      //  System.out.println("Explored: " + node);
    }
}
