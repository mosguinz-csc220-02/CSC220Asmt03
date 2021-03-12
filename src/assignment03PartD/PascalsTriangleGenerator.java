/*
 * **********************************************
 * San Francisco State University
 * CSC 220 -  Data Structures
 * File Name: PascalsTriangleGenerator.java
 * Author: Java Foundation
 * Author: Duc Ta
 * Author: Kullathon Sitthisarnwattanachai
 * **********************************************
 */

package assignment03PartD;

public class PascalsTriangleGenerator {

    public PascalsTriangleGenerator() {
    }

    /**
     * Recursively computes the n-th row of the Pascal's triangle, where the row numbering starts at
     * 1, with each n-th row containing n integers.
     *
     * @param rowToCompute The n-th row of the Pascal's triangle to compute, where n > 0.
     * @return An array of integers of the n-th row.
     */
    public int[] computeRow(int rowToCompute) {
        // Base case: first row contains exactly one element: 1.
        if (rowToCompute == 1) {
            return new int[]{1};
        }

        // Recursive call to compute the previous row to use in computing `thisRow`.
        int[] previousRow = computeRow(rowToCompute - 1);

        // Row `n` contains `n` numbers.
        int[] thisRow = new int[rowToCompute];

        // Row always begin with 1.
        thisRow[0] = 1;

        // Calculate the interior numbers (non-1s) by summing the ones above.
        for (int i = 1; i < previousRow.length; i++) {
            thisRow[i] = previousRow[i - 1] + previousRow[i];
        }

        // Row always end with 1.
        thisRow[previousRow.length] = 1;

        return thisRow;
    }
}
