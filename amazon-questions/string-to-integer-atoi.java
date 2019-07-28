// https://leetcode.com/problems/string-to-integer-atoi

class Solution {
    public int myAtoi(String str) {
        if(str.length()==0) return 0;
        
        boolean minus=false;
        int start = -1, end =0;
        for (int i = 0; i < str.length(); i++) {
        	if(start==-1) {
        		if(str.charAt(i)==' ') continue;
        		if(str.charAt(i)=='+' || str.charAt(i)=='-') {
        			start = i;
        			end = i;
        		} else if(str.charAt(i)>='0' && str.charAt(i)<='9') {
        			start=i;
        			end = i;
        		} else {
        			return 0;
        		}
        	} else {
        		if(str.charAt(i)>='0' && str.charAt(i)<='9') end = i;
    			else break;
        	}
		}
        if(start==-1) return 0;
        if(start==end && (str.charAt(start)<'0' || str.charAt(start)>'9')) return 0;
        if(str.charAt(start) == '+') start +=1;
        if(str.charAt(start) == '-') {
        	minus = true;
        	start +=1;
        }
        
        long val = 0;
        for (int i = end; i >=start; i--) {
			val += (int) ( (str.charAt(i)-48) * Math.pow(10, end-i) );
			
			if(minus) {
				if(-1*val< Integer.MIN_VALUE) return Integer.MIN_VALUE;
			}
			else if(val > Integer.MAX_VALUE) {
				return Integer.MAX_VALUE;
			} 
		}
        if(minus) val *=-1;
        return (int)val;
    }
}
