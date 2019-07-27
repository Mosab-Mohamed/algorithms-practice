// https://leetcode.com/problems/number-of-islands

class Solution {
    public void BFS(char[][] grid, boolean[][] bool, int row, int col) {
		if(row == grid.length || col == grid[0].length) return;
		if(row == -1 || col == -1) return;
		if(bool[row][col] || grid[row][col]=='0') return;

		bool[row][col] = true;
		BFS(grid, bool, row+1, col);
		BFS(grid, bool, row-1, col);
		BFS(grid, bool, row, col+1);
		BFS(grid, bool, row, col-1);		
	}
    
    public int numIslands(char[][] grid) {
        if(grid.length ==0 ) return 0;
        int count = 0;
		boolean[][] visited = new boolean[grid.length][grid[0].length];

        for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if(grid[i][j]=='1' && !visited[i][j]) {
					BFS(grid, visited, i, j);
					count++;
				}
				visited[i][j] = true;
			}
		}
        return count;
    }
}
