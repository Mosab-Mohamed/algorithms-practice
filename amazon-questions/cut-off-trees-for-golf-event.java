// https://leetcode.com/problems/cut-off-trees-for-golf-event

class Solution {
    class Pair {
        int row;
        int col;
        
        public Pair(int r, int c) {
            row = r;
            col = c;
        }
    }
    
    class Trio {
        int row;
        int col;
        int height;
        
        public Trio(int r, int c, int h){
            row = r;
            col = c;
            height = h;
        }
    }
    
    void visitNeighbour(List<List<Integer>> forest, boolean[][] visited, Queue<Pair> helper, int row, int col, int rows, int cols) {
        if(row < 0 || row >= rows || col < 0 || col>= cols) return;
        if(forest.get(row).get(col) != 0 && !visited[row][col]) {
            visited[row][col] = true;
            helper.add(new Pair(row, col));
        }
    }
    
    
    public int cutOffTree(List<List<Integer>> forest) {
        PriorityQueue<Trio> pq = new PriorityQueue<Trio>((a,b) -> a.height - b.height);
        int treesCount=0;
        
        int i=0 ,j=0;
        for(List<Integer> list : forest) {
            j=0;
            for(Integer v : list) {
                if(v > 1) {
                    pq.offer(new Trio(i, j, v));
                    treesCount++;
                }
                j++;
            }
            i++;
        }
        
        boolean[][] visited = new boolean[i][j];
        Queue<Pair> helper = new LinkedList<Pair>();
        helper.add(new Pair(0, 0));
        
        int moves = 0;

        Trio target = pq.poll();

        while(!helper.isEmpty()) {
            int size = helper.size();
            boolean found = false;
            for(int k=0; k<size; k++) {
                Pair curr = helper.poll();
                
                if(curr.row == target.row && curr.col == target.col) {
                    helper.clear();
                    found = true;
                    visited = new boolean[i][j];
                    if(pq.isEmpty()) {
                        return moves;
                    } else {
                        target = pq.poll();
                    }
                }
                visitNeighbour(forest, visited, helper, curr.row+1, curr.col, i, j);
                visitNeighbour(forest, visited, helper, curr.row-1, curr.col, i, j);
                visitNeighbour(forest, visited, helper, curr.row, curr.col+1, i, j);
                visitNeighbour(forest, visited, helper, curr.row, curr.col-1, i, j);
                
                if(found)
                    break;
            }
            
            if(helper.isEmpty()) return -1;

            moves++;
        }
        return moves;
    }
}
