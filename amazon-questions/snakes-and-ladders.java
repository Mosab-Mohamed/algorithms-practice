// https://leetcode.com/problems/snakes-and-ladders

class Solution {
    
    int[] flatten(int[][] board) {
    	int n = board.length;
    	int[] res = new int[n*n + 1];
    	
    	int index = 1;
    	boolean left = true;
    	for (int i = n-1; i>=0; i--) {
    		if(left) {
    			for (int j = 0; j < n; j++) {
        			res[index++] = board[i][j];
        		}
    		} else {
    			for (int j = n-1; j>=0; j--) {
        			res[index++] = board[i][j];
        		}
    		}
    		left = !left;
		}
    	return res;
    }
    
    
    public int snakesAndLadders(int[][] board) {
        int n = board.length;

        int[] newBoard = flatten(board);
        boolean[] visited = new boolean[n*n+1];
        Queue<Integer> q = new LinkedList();

        q.add(1);
        visited[1] = true;

        int res = 0;  
        while (!q.isEmpty()) {
            int size = q.size();

            for(int i=0; i<size; i++) {
                int s = q.remove();
                if (s == n*n) return res;

                for (int j = s + 1; j <= Math.min(s + 6, n*n); ++j) {
                   int nextItem = newBoard[j] == -1 ? j : newBoard[j];

                   if(!visited[nextItem]) {
                      visited[nextItem] = true;
                      q.add(nextItem);
                   }
                }
            }
            res++;
        }

        return -1;
    }
}
