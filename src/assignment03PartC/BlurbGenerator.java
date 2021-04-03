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

    /**
     * Maximum number of 'y's allowed following any given Whoozits.
     */
    private static final int MAX_WHOOZIT_Y_SIZE = 5;

    /**
     * Maximum number of Whatzits allowed in any given Blurb.
     */
    private static final int MAX_WHAZITS = 5;

    /**
     * Instantiates a random number generator needed for blurb creation.
     */
    public BlurbGenerator() {
        // Nothing here! We generate them on each blurbs.
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
     *
     * @return A Blurb.
     */
    public String makeBlurb() {
        return makeWhoozit() + makeMultiWhatzits(getRandInt(1, MAX_WHAZITS));
    }

    /**
     * Generates a random Whoozit. A Whoozit is the character 'x' followed by zero or more 'y's.
     *
     * @return A Whoozit.
     */
    private String makeWhoozit() {
        return "x" + makeYString(getRandInt(0, MAX_WHOOZIT_Y_SIZE));
    }

    /**
     * Recursively generates a string of zero or more 'y's.
     *
     * @param n Number of 'y's to generate.
     * @return n-amount of 'y's.
     */
    private String makeYString(int n) {
        return n == 0 ? "" : makeYString(n - 1) + "y";
    }

    /**
     * Recursively generates a string of one or more Whatzits.
     *
     * @param n Number of Whazits to generate.
     * @return n-amount of Whazits.
     */
    private String makeMultiWhatzits(int n) {
        return n == 0 ? "" : makeMultiWhatzits(n - 1) + makeWhatzit();
    }

    /**
     * Generates a random Whatzit. A Whatzit is a 'q' followed by either a 'z' or a 'd', followed by
     * a Whoozit.
     *
     * @return A Whazit.
     */
    private String makeWhatzit() {
        return "q" + (getRandInt(0, 1) == 0 ? "d" : "z") + makeWhoozit();
    }
}