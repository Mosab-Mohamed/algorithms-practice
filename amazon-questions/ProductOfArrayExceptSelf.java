// https://leetcode.com/problems/product-of-array-except-self

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] solution = new int[nums.length];
        
        solution[0] = 1;
        for (int i = 1; i < solution.length; i++) {
			solution[i] = solution[i-1] * nums[i-1];
		}
        
        int prev = 1;
        for (int i = solution.length-2; i >=0; i--) {
        	prev *= nums[i+1];
			solution[i] *= prev;
		}
        return solution;
    }
}
