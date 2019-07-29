// https://leetcode.com/problems/rotate-array

class Solution {
    public void rotate(int[] nums, int k) {
        int swapped=0, n=nums.length;
        while(swapped < k) {
            int tmp = nums[n-1];
            for(int i=n-1; i>0; i--){
                nums[i]= nums[i-1];
            }
            nums[0] = tmp;
            swapped++;
        }
    }
}
