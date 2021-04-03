/*
 * **********************************************
 * San Francisco State University
 * CSC 220 -  Data Structures
 * File Name: Assignment02PartE01.java
 * Author: Duc Ta
 * Author: Kullathon Sitthisarnwattanachai
 * **********************************************
 */

package assignment03PartE;

public class Assignment03PartE01 {

    public static void main(String[] args) {
        // 3 ops for assignments of i, n, and sum.
        int ops = 3;

        int i, n = 5, sum = 5;
        for (i = 5; i < 3 * n; i++) {
            // 2 ops for termination expression: one for < and one for *
            // runs each time loop executes (and +1 at the end)
            ops += 2;

            // 2 ops for incrementation: one for + and one for =
            // runs each time loop executes
            ops += 2;

            // 5 ops for statement below: once for each operator and one additional for =
            // runs each time loop executes
            ops += 5;

            // sum *= n + (i * 7) + 37;
            sum = sum * (n + (i * 7) + 37);
        }

        // termination expression (2 ops) runs once more when it fails
        ops += 2;

        System.out.println(sum);
        System.out.printf("ops: %d", ops);
    }
}
