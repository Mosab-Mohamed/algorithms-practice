// https://leetcode.com/problems/reverse-words-in-a-string

class Solution {
    public String reverseWords(String s) {
        String[] ss = s.split(" ");
        StringBuilder sb = new StringBuilder();
        
        int lastNonEmptyIndex = 0;
        for(int i=0; i<ss.length; i++){
            if(!ss[i].equals("")){
                lastNonEmptyIndex = i;
                break;
            }
        }

        for(int i=ss.length-1; i>=lastNonEmptyIndex; i--){
            if(!ss[i].equals("")){
                sb.append(ss[i]);
                if(i!=lastNonEmptyIndex) sb.append(" ");
            }
        }
        
        return sb.toString();
    }
}
