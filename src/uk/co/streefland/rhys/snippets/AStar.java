package uk.co.streefland.rhys.snippets;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * Created by Rhys on 09/11/2016.
 */
public class AStar {

    public static void main(String[] args) {
        int[][] map =
                        {{0, 0, 1, 0, 0},
                        {1, 0, 1, 0, 1},
                        {1, 0, 0, 0, 0},
                        {0, 0, 1, 1, 0},
                        {0, 1, 0, 0, 0}};

        String[][] output = new String[map.length][map.length];

        for(int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {
                output[i][j] =  "" + map[i][j];
            }
        }

        aStar(map,output, new Coordinate(0,0), new Coordinate(0,4));
    }

    public static void aStar(int[][] map, String[][] output, Coordinate start, Coordinate goal) {

        Coordinate[] neighbours = {new Coordinate(0, 1), new Coordinate(0, -1), new Coordinate(1, 0),
                                    new Coordinate(-1, 0), new Coordinate(1, 1), new Coordinate(1, -1),
                                    new Coordinate(-1, 1), new Coordinate(-1, -1)};

        PriorityQueue<Coordinate> openSet = new PriorityQueue<>();
        ArrayList<Coordinate> closedSet = new ArrayList<>();
        Coordinate[][] cameFrom = new Coordinate[map.length][map.length];

        // For each node, the cost of getting from the start node to that node.
        int[][] gScore = new int[map.length][map.length];
        gScore[start.getX()][start.getY()] = 0;

        // For each node, the total cost of getting from the start node to the goal
        // by passing by that node. That value is partly known, partly heuristic.
        int[][] fScore = new int[map.length][map.length];
        fScore[start.getX()][start.getY()] = heuristic(start, goal);

        openSet.add(start);

        while (!openSet.isEmpty()) {

            Coordinate current = openSet.remove();

            if (current.equals(goal)) {
                reconstructPath(cameFrom, current, output);
            }

            closedSet.add(current);

            for (Coordinate neighbour: neighbours) {

                Coordinate n = new Coordinate(current.getX() + neighbour.getX(), current.getY() + neighbour.getY());

                if (n.getX() < 0 || n.getX() == map.length || n.getY() < 0 || n.getY() == map.length) {
                    continue;
                }

                /* THIS ONLY NEEDS TO EXIST IF YOU WANT THE NUMBER 1 TO FUNCTION AS WALLS - else it will use the numbers as weights */
                if (map[n.getX()][n.getY()] == 1) {
                    continue;
                }

                if (closedSet.contains(n)) {
                    continue;
                }

                // The distance from start to a neighbor
                int tentativeGScore = gScore[current.getX()][current.getY()] + (n.getX() + n.getY()) + map[n.getX()][n.getY()];

                if (!openSet.contains(n)) {
                    n.setFScore(tentativeGScore + heuristic(n, goal));
                    openSet.add(n);
                } else if (tentativeGScore > gScore[n.getX()][n.getY()]) {
                    continue; // This is not a better path.
                }

                // This path is the best until now. Record it!
                cameFrom[n.getX()][n.getY()] = current;
                gScore[n.getX()][n.getY()] = tentativeGScore;
                fScore[n.getX()][n.getY()] = gScore[n.getX()][n.getY()] + heuristic(n, goal);
            }
        }
    }

    public static int heuristic(Coordinate a, Coordinate b) {
        return Math.abs(a.getX() - b.getX()) + Math.abs(a.getY() - b.getY());
    }

    public static void reconstructPath(Coordinate[][] cameFrom, Coordinate current, String[][] output) {
        ArrayList<Coordinate> totalPath = new ArrayList<>();

        totalPath.add(current);

        while (current != null) {
            current = cameFrom[current.getX()][current.getY()];

            if (current != null) {
                totalPath.add(current);
            }
        }

        for (int i = totalPath.size()-1; i >= 0; i--) {
            output[totalPath.get(i).getX()][totalPath.get(i).getY()] = "x";
            drawGrid(output);
        }
    }

    public static void drawGrid(String[][] output) {
        // Print the top axis
        System.out.print("|");
        for (int i = 0; i < output.length * 2; i++) {
            System.out.print("-");
        }
        System.out.print("-|\n");

        // Cycle through every element of the world and print to screen
        for (int i = 0; i < output.length; i++) {
            System.out.print("|"); // left side boundary
            for (int j = 0; j < output.length; j++) {
                System.out.print(" "); // blank space to pad the grid
                // horizontally
                System.out.print(output[i][j]);
            }
            System.out.print(" |"); // right side boundary
            System.out.print("\n"); // new line
        }

        // Print the bottom axis
        System.out.print("|");
        for (int i = 0; i < output.length * 2; i++) {
            System.out.print("-");
        }
        System.out.print("-|\n");
    }
}
