package arrays.medium;

import java.util.ArrayList;

public class SetMatrixZeroes {


    //OPTIMAL APPROACH--------------------------------------------------------------------------------------------------
    public void setZeroes(int[][] matrix) {

        boolean firstCol = false;
        boolean firstRow = false;

        for(int i=0; i < matrix.length; i++){
            for(int j =0; j < matrix[0].length; j++){
                if(matrix[i][j] == 0){
                    if(i == 0) firstRow = true;
                    if(j == 0) firstCol = true;
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }

        for(int i =1; i < matrix.length; i++){
            for(int j =1; j < matrix[0].length; j++){
                if(matrix[i][0] == 0 || matrix[0][j] ==0){
                    matrix[i][j] = 0;
                }
            }
        }

        if(firstRow){
            for(int j =0; j < matrix[0].length; j++){
                matrix[0][j] = 0;
            }
        }

        if(firstCol){
            for(int i =0; i < matrix.length; i++){
                matrix[i][0] = 0;
            }
        }
    }





    //BETTER APPROACH---------------------------------------------------------------------------------------------------
    public static ArrayList<ArrayList<Integer>> zeroMatrix(ArrayList<ArrayList<Integer>> matrix, Integer n, Integer m) {
        // Write your code here.
        int[] row = new int[n];
        int[] col = new int[m];

        for(int i=0; i < n; i++){
            for(int j =0; j < m; j++){
                if(matrix.get(i).get(j) == 0){
                    row[i] = 1;
                    col[j] = 1;
                }
            }
        }

        for(int i =0; i < n; i++){
            for(int j =0; j < m; j++){
                if(row[i] == 1 || col[j] == 1){
                    matrix.get(i).set(j,0);
                }
            }
        }
        return matrix;
    }


}
