package uk.co.streefland.rhys.oddsandsods;

/**
 * Created by Rhys on 31/10/2016.
 */
public class FizzBuzz {

    public static void main(String[] args) {

        for (int i=1; i<=100; i++) {
            if (i % 3 == 0) {
                System.out.println("Fizz");
            } else if (i % 5 == 0) {
                System.out.println("Buzz");
            } else {
                System.out.println(i);
            }
        }
    }
}
