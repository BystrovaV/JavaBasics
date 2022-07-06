package com.epam.rd.autotasks.matrices;
import java.util.Arrays;

public class MultiplyMatrix {
    public static int[][] multiply(int[][] matrix1, int[][] matrix2) {

        int rows = matrix1.length, columns = matrix2[0].length;
        int [][] multiplyMatrix = new int[rows][columns];

        int sum;
        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix2[0].length; j++) {
                sum = 0;
                for (int k = 0; k < matrix2.length; k++) {
                   sum += matrix1[i][k] * matrix2[k][j];

                }
                multiplyMatrix[i][j] = sum;
            }
        }

        return multiplyMatrix;
    }

    public static void main(String[] args) {

        System.out.println("Test your code here!\n");

        // Get a result of your code

        int[][] a = {
                {0, 12345},
                {4509, 0},
                {3, 567} };

        int[][] b = {
                {653, 0, 25353},
                {0, 61, 6} };

        int[][] result = multiply(a, b);
        System.out.println(Arrays.deepToString(result).replace("],", "]\n"));
    }
}
