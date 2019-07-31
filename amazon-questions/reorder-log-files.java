// https://leetcode.com/problems/reorder-log-files

class Solution {
    
	public boolean isStringLog(String s1) {
		return s1.charAt(0) >= 'a' && s1.charAt(0) <= 'z';
	}
	
	public boolean isDigitLog(String s1) {
		return s1.charAt(0) >= '0' && s1.charAt(0) <= '9';
	}
	
	public int compareIds(String id1, String id2) {
        int minLen = Math.min(id1.length(), id2.length());

        for(int i=0; i<minLen; i++){
            int char1 = (int) id1.charAt(i);
            int char2 = (int) id2.charAt(i);
            
            if(char1 != char2)
                return char1- char2;
        }
        
        if(id1.length() != id2.length())
            return id2.length() - id1.length();
        
        return 0;
    }
	
    public int compareStrings(String s1, String s2) {
    	String id1 = s1.substring(0, s1.indexOf(' ')+1);
        String id2 = s2.substring(0, s2.indexOf(' ')+1);
        
        String word1 = s1.substring(s1.indexOf(' ')+1);
        String word2 = s2.substring(s2.indexOf(' ')+1);

        int minLen = Math.min(word1.length(), word2.length());
        
        if(isStringLog(word1) && isDigitLog(word2))
        	return -1;
        else if(isStringLog(word2) && isDigitLog(word1))
        	return 1;
        else if(isDigitLog(word1) && isDigitLog(word2))
            return 0;
        
        for(int i=0; i<minLen; i++){
            int char1 = (int) word1.charAt(i);
            int char2 = (int) word2.charAt(i);
            
            if(char1 != char2)
                return char1- char2;
        }
        
        if(word1.length() != word2.length())
            return word2.length() - word1.length();
        
        return compareIds(id1, id2);
    }
    
    public String[] merge(String[] arr1, String[] arr2) {
        int ind1=0, ind2=0;
        String[] sorted= new String[arr1.length + arr2.length];
        int i=0;
        while(ind1< arr1.length && ind2<arr2.length) {
            if(compareStrings(arr1[ind1], arr2[ind2]) > 0 ) {
                sorted[i++] = arr2[ind2];
                ind2++;
            } else {
                sorted[i++] = arr1[ind1];
                ind1++;
            }
        }

        if(ind1 < arr1.length) {
            for(int j=ind1; j<arr1.length; j++) sorted[i++] = arr1[j];
        } else if(ind2 < arr2.length) {
            for(int j=ind2; j<arr2.length; j++) sorted[i++] = arr2[j];
        }

        return sorted;
    }

    public String[] mergeSort(String[] logs, int start, int end) {
        if( start>end) return new String[] {};
        if( start==end ) return new String[] {logs[start]};
        int middle = start + (end-start)/2;
        String[] arr1 = mergeSort(logs, start, middle);
        String[] arr2 = mergeSort(logs, middle+1, end);
        return merge(arr1, arr2 );
    }

    public String[] reorderLogFiles(String[] logs) {
        String[] res = mergeSort(logs, 0, logs.length-1);
        return res;
    }
    
}
