/*
 * **********************************************
 * San Francisco State University
 * CSC 220 -  Data Structures
 * File Name: BlurbGenerator.java
 * Author: Java Foundation
 * Author: Duc Ta
 * Author: Kullathon Sitthisarnwattanachai
 * **********************************************
 */

package assignment03PartC;

public class BlurbGenerator {

    private static final int MIN_BLURB_SIZE = 4;
    private static final int MAX_BLURB_SIZE = 21;
    private static final int MAX_WHOOZIT_Y_SIZE = 5;
    private final int blurbSize;

    /**
     * Instantiates a random number generator needed for blurb creation.
     */
    public BlurbGenerator() {
        blurbSize = getRandInt(MIN_BLURB_SIZE, MAX_BLURB_SIZE);
        System.out.println(blurbSize);
    }

    /**
     * Helper to return a random integer in the range [min, max].
     *
     * @param min Minimum value, inclusive.
     * @param max Maximum value, inclusive.
     * @return The random integer.
     */
    private static int getRandInt(int min, int max) {
        return (int) (Math.random() * (max - min + 1) + min);
    }

    /**
     * Generates and returns a random Blurb. A Blurb is a Whoozit followed by one or more Whatzits.
     */
    public String makeBlurb() {
        StringBuilder blurb = new StringBuilder(makeWhoozit() + makeWhatzit());
        while (blurb.length() < MIN_BLURB_SIZE) {
            blurb.append(makeWhatzit());
        }
        return blurb.toString();
    }

    /**
     * Generates a random Whoozit. A Whoozit is the character 'x' followed by zero or more 'y's.
     */
    private String makeWhoozit() {
        return "x" + makeYString(getRandInt(0, MAX_WHOOZIT_Y_SIZE));
    }

    /**
     * Recursively generates a string of zero or more 'y's.
     */
    private String makeYString(int ySize) {
        return ySize == 0 ? "" : makeYString(ySize - 1) + "y";
    }

    /**
     * Recursively generates a string of one or more Whatzits.
     */
    private String makeMultiWhatzits() {
        return null;
    }

    /**
     * Generates a random Whatzit. A Whatzit is a 'q' followed by either a 'z' or a 'd', followed by
     * a Whoozit.
     */
    private String makeWhatzit() {
        final int x = getRandInt(0, 1);
        return "q" + (x == 0 ? "d" : "z") + makeWhoozit();
    }
}