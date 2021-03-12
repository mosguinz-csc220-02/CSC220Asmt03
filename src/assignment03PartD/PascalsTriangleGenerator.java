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

    public int[] computeRow(int rowToCompute) {
        int[][] triangle = new int[rowToCompute][];
        triangle[0] = new int[]{1};

        for (int i = 1; i < triangle.length ; i++) {
            final int[] previousRow = triangle[i - 1];
            int[] thisRow = new int[i + 1];
            thisRow[0] = thisRow[i] = 1;
            for (int j = 1; j < previousRow.length; j++) {
                thisRow[j] = previousRow[j - 1] + previousRow[j];
            }
            triangle[i] = thisRow;
        }
        return triangle[rowToCompute - 1];
    }
}
