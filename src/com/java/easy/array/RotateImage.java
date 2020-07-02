//You are given an n x n 2D matrix representing an image.
//
//        Rotate the image by 90 degrees (clockwise).

// Hint: matrix transpose and then reverse

package com.java.easy.array;

public class RotateImage {
    public RotateImage(){}

    public void rotate(int[][] matrix) {
        int n = matrix.length;

        //matrix transpose
        for(int i = 0; i < n; i++){
            for (int j = i; j < n; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // matrix reverse
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n/2; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n - j - 1];
                matrix[i][n - j -1] = temp;
            }
        }
    }
}
