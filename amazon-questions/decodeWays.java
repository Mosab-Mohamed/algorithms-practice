// https://leetcode.com/problems/decode-ways

class Solution {

    
    int dfs(String s, int index, int count) {
        if(index >= s.length()) {
            return count+1;
        }
        
        for(int i=index; i<s.length(); i++) {
            int val = Integer.parseInt(s.substring(index, i+1));
            if(val <= 26 && val > 0) {
                count = dfs(s, i+1, count);
            } else {
                break;
            }
        }
        
        return count;
    }
    
    public int numDecodings(String s) {
        int n= s.length();

        int prev = 0;
        int cur = 1;
        for(int i=1; i<=n; i++) {
            int tmp = 0;
            int lastDigit = Integer.parseInt(s.substring(i-1, i));
            if(lastDigit != 0) {
                tmp += cur;
            }
            
            if(i >= 2) {
                int lastTwoDigits = Integer.parseInt(s.substring(i-2, i));
                if(lastTwoDigits > 9 && lastTwoDigits <= 26){
                    tmp += prev;
                }
            }
            
            prev = cur;
            cur = tmp;
        }
        return cur;
    }
}
