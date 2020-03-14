// https://leetcode.com/problems/rotting-oranges

  class Solution {
    
    void visitNieghbours(int[][] grid, boolean[][] visited, Queue<int[]> rottenCells, int rows, int columns, int row, int column) {
        if(row>=rows || row<0 || column>=columns || column<0) return;
        if(visited[row][column] || grid[row][column] != 1) return;
        
        rottenCells.add(new int[] {row, column});
        visited[row][column] = true;
        grid[row][column] = 2;
    }

    public int orangesRotting(int[][] grid) {
        if(grid.length == 0 || grid[0].length == 0) return -1;
        
        int rows = grid.length;
        int columns = grid[0].length;
        
        Queue<int[]> rottenCells = new LinkedList<int[]>();
        boolean[][] visited = new boolean[rows][columns];
        int nonEmptyCells = 0;

        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j] == 2) {
                    rottenCells.add(new int[] {i, j});
                    visited[i][j] = true;
                }
                if(grid[i][j] > 0)
                    nonEmptyCells++;
            }
        }

        int rottenCount = rottenCells.size();
        int minutesNumber = 0;
        
        while( !rottenCells.isEmpty() && rottenCount < nonEmptyCells ) {
            minutesNumber++;
            
            int n = rottenCells.size();
            for(int i=0; i<n; i++) {
                int[] cell = rottenCells.remove();
                
                visitNieghbours(grid, visited, rottenCells, rows, columns, cell[0]+1, cell[1]);
                visitNieghbours(grid, visited, rottenCells, rows, columns, cell[0]-1, cell[1]);
                visitNieghbours(grid, visited, rottenCells, rows, columns, cell[0], cell[1]+1);
                visitNieghbours(grid, visited, rottenCells, rows, columns, cell[0], cell[1]-1);
            }
            rottenCount += rottenCells.size();
        }
        
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j] == 1) {
                    return -1;
                }
            }
        }
        
        return minutesNumber;
        
    }
}
