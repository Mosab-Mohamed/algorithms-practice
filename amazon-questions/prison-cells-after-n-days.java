// https://leetcode.com/problems/prison-cells-after-n-days

class Solution {
    void updateCells(int[] cells){
        int tmp1, tmp2;
        
        tmp2=cells[0];
        for(int j=1; j<7; j++){
            tmp1=cells[j];
            cells[j] = tmp2 == cells[j+1] ? 1 : 0;
            tmp2=tmp1;
        }
        cells[0] = 0;
        cells[7] = 0;
    }
    
    String getCellsString(int[] cells) {
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<cells.length; i++)
            sb.append(cells[i]);

        return sb.toString();
    }
    
    public int[] prisonAfterNDays(int[] cells, int N) {
        if(N==0) return cells;
        
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        map.put( getCellsString(cells), 0);
        
        
        int remainingIterations=0;

        for(int i=1; i<=N; i++){
           updateCells(cells);
            
            if(map.containsKey( getCellsString(cells))){
                int cycleSize = i - map.get( getCellsString(cells));
                if(cycleSize==0) return cells;
                
                remainingIterations = (N-i) % cycleSize;
                break;
            } else {
                map.put( getCellsString(cells), i);
            }
        }
        
        if(remainingIterations==0) return cells;
        
        for(int i=0; i<remainingIterations; i++){
            updateCells(cells);
        }
        return cells;
    }
}
