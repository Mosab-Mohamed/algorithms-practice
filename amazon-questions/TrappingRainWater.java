// https://leetcode.com/problems/trapping-rain-water

class Solution {
    public int trap(int[] height) {
        int tallestIndex = 0;
        int trapsCount = 0;
        int currentTallest = 0;

        for(int i=0 ; i< height.length; i++) {
        	if( height[i] > height[tallestIndex]) tallestIndex = i;
        }
        
        for (int i = 0; i < tallestIndex; i++) {
			if(currentTallest == 0 && height[i] != 0) currentTallest = height[i];
			else if(currentTallest < height[i]) currentTallest = height[i];

			if(currentTallest > height[i]) trapsCount += currentTallest - height[i];			
		}
        
        currentTallest = 0;
        for (int i = height.length-1 ; i > tallestIndex; i--) {
			if( (currentTallest == 0 && height[i] != 0) || currentTallest < height[i]) currentTallest = height[i];

			if(currentTallest > height[i]) trapsCount += currentTallest - height[i];			
		}

        return trapsCount;
    }
}
