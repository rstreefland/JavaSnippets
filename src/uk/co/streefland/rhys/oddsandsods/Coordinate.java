package uk.co.streefland.rhys.oddsandsods;

/**
 * Created by Rhys on 09/11/2016.
 */
public class Coordinate implements Comparable<Coordinate> {

    private int x;
    private int y;
    private int fScore;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Coordinate) {
            Coordinate c = (Coordinate) obj;

            if (this.x == c.getX() && this.y == c.getY()) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int compareTo(Coordinate o) {
        if (o.fScore == this.fScore) {
            return 0;
        } else {
            return this.fScore > o.fScore ? 1 : -1;
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getFScore() {
        return fScore;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setFScore(int fScore) {
        this.fScore = fScore;
    }
}
