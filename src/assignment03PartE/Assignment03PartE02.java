/*
 * **********************************************
 * San Francisco State University
 * CSC 220 -  Data Structures
 * File Name: Assignment02PartE02.java
 * Author: Duc Ta
 * Author: Kullathon Sitthisarnwattanachai
 * **********************************************
 */

package assignment03PartE;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Assignment03PartE02 {

    public static void main(String[] args) {
        // Set this to true for CSV-like output. Also runs infinitely.
        boolean printToCsv = true;

        // Disable print to console; reduce lag.
        boolean printToConsole = true;

        // Maximum value of `n` to test. 1 to `n`, inclusive.
        int runUntil = 10000;

        /* Spaghetti below ************************************************************************/
        int n;
        String humanFormat = "[n = %-8d] %-15s ns vs %-15s ns%n";
        String csvFormat = "%d,%d,%d%n";
        PrintWriter fOut = null;

        try {
            fOut = new PrintWriter("./src/assignment03PartE/AvB.csv");
            fOut.println("n,Loop A (ns),Loop B (ns)");
        } catch (FileNotFoundException e) {
            System.err.println(e);
        }

        for (n = 1; n <= runUntil; n++) {
            long start, stop, deltaA, deltaB;

            // Time loop A
            start = System.nanoTime();
            loopA(n);
            stop = System.nanoTime();
            deltaA = stop - start;

            // Time loop B
            start = System.nanoTime();
            loopB(n);
            stop = System.nanoTime();
            deltaB = stop - start;

            // Output in csv format
            if (printToCsv) {
                fOut.printf(csvFormat, n, deltaA, deltaB);
            }

            if (!printToConsole) {
                continue;
            }

            // Output for human eyes
            if (deltaA < deltaB) {
                System.out.printf(humanFormat, n, colorFaster(deltaA), colorSlower(deltaB));
            } else {
                System.out.printf(humanFormat, n, colorSlower(deltaA), colorFaster(deltaB));
            }
        }
        fOut.close();
    }

    private static String colorFaster(long d) {
        return "\033[0;32m" + d + "\033[0m";
    }

    private static String colorSlower(long d) {
        return "\033[0;31m" + d + "\033[0m";
    }

    private static void loopA(int n) {
        int i, j, sum = 0;
        for (i = 1; i <= n; i++) {
            for (j = 1; j <= 10000; j++) {
                sum = sum + j;
            }
        }
    }


    private static void loopB(int n) {
        int i, j, sum = 0;
        for (i = 1; i <= n; i++) {
            for (j = 1; j <= n; j++) {
                sum = sum + j;
            }
        }
    }

}