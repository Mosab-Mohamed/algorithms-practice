// https://leetcode.com/problems/set-matrix-zeroes

class Solution {
    public void setZeroes(int[][] matrix) {
        if(matrix.length == 0) return;
        if(matrix.length == 1 && matrix[0].length == 1) return;
        
        boolean firstRowZero = false, firstColZero = false;
        for(int i=0; i<matrix.length; i++){
            if(matrix[i][0]==0) firstColZero=true;
        }
        
        for(int i=0; i<matrix[0].length; i++){
            if(matrix[0][i]==0) firstRowZero=true;
        }
        
        for(int i=1; i<matrix.length; i++){
            for(int j=1; j<matrix[0].length; j++){
                if(matrix[i][j]==0){
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }
        
        
        for(int i=1; i<matrix[0].length; i++){
            if(matrix[0][i]==0){
                for(int j=1; j<matrix.length; j++){
                    matrix[j][i] = 0;
                }
            }
        }
        for(int i=1; i<matrix.length; i++){
            if(matrix[i][0]==0){
                for(int j=1; j<matrix[0].length; j++){
                    matrix[i][j]=0;
                }
            }
        }
        
        if(firstRowZero){
            for(int j=0; j<matrix[0].length; j++){
                matrix[0][j] = 0;
            }
        }
        if(firstColZero){
            for(int j=0; j<matrix.length; j++){
                matrix[j][0] = 0;
            }
        }
    }
}
