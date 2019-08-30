// https://leetcode.com/problems/decode-string

class Solution {
    public String decodeString(String s) {
        Stack<String> st = new Stack<String>();
        StringBuilder sb = new StringBuilder();
        
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == ']') {
                sb = new StringBuilder();
                String currentStr = st.pop();
                while(!currentStr.equals("[")){
                    sb.insert(0, currentStr);
                    currentStr = st.pop();
                }
                
                String encodedStr = sb.toString();
                
                if(st.peek().charAt(0) >= '0' && st.peek().charAt(0) <= '9'){
                    sb = new StringBuilder();

                    while(!st.empty() && st.peek().charAt(0) >= '0' && st.peek().charAt(0) <= '9'){
                        sb.insert(0, st.peek());
                        st.pop();
                    }

                    int repeat = Integer.parseInt(sb.toString());
                    sb = new StringBuilder();                    
                    for(int j=0; j<repeat; j++){
                        sb.append(encodedStr);
                    }
                    st.push(sb.toString());
                }
            } else {
                st.push(Character.toString(s.charAt(i)));
            }
        }
        
        sb = new StringBuilder();
        while(!st.empty()) sb.insert(0, st.pop());
        
        return sb.toString();
    }
}
