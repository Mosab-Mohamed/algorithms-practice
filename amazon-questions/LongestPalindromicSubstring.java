// https://leetcode.com/problems/longest-palindromic-substring

class Solution {
    public String longestPalindrome(String s) {
        if(s.isEmpty()) return s;
        
        int n= s.length();
		int low, high;
		int start=0, end=0;
		
		for (int i = 1; i < n ; i++) {
			low = i-1;
			high = i;
			while ( low>=0 && high< n && s.charAt(low) == s.charAt(high) ) {
				if(high-low > end-start) {
					start = low;
					end = high;
				}
				low--;
				high++;
			}
			
			low = i-1;
			high = i+1;
			while ( low>=0 && high< n && s.charAt(low) == s.charAt(high) ) {
				if(high-low > end-start) {
					start = low;
					end = high;
				}
				low--;
				high++;
			}
		}
        return s.substring(start, end+1);
    }
}
