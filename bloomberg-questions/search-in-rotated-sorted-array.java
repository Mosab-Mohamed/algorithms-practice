// https://leetcode.com/problems/search-in-rotated-sorted-array

class Solution {
    public int search(int[] nums, int target) {
        if(nums.length == 0) return -1;
        
        int n = nums.length;
        
        int start = 0, end = n-1, pivot = 0, middle=0;
        
        while(start <= end){
            middle = start + (end-start)/2;
            if(middle>0 && nums[middle-1] > nums[middle]){
                pivot = middle;
                break;
            }

            if(nums[middle] > nums[end]){
                start = middle+1;
            } else {
                end = middle-1;
            }
        }
        
        if(target >= nums[pivot] && target <= nums[n-1]){
            start = pivot;
            end = n-1;
        } else {
            start = 0;
            end = pivot-1;
        }
        
        while(start <= end){
            middle = start + (end-start)/2;
            if(nums[middle] == target){
                return middle;
            }

            if(nums[middle] < target){
                start = middle+1;
            } else {
                end = middle-1;
            }
        }
        
        return -1;
        
    }
}
