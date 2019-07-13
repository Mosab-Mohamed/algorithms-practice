// https://leetcode.com/problems/two-sum/

class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> diff = new HashMap<Integer, Integer>();
        int[] result = new int[2];
        
        for (int i = 0; i < nums.length; i++) {
            if (diff.containsKey(nums[i])) {    	
            	result[0] = diff.get(nums[i]);
            	result[1] = i;
            	return result;
            } else {
                diff.put(target - nums[i], i);
            }
        }
        
        return result;
    }
}
