// https://leetcode.com/problems/valid-parentheses

class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<Character>();
		 int n = s.length();
		 for (int i = 0; i < n; i++) {
			if(s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
				st.push(s.charAt(i));
			} else if(s.charAt(i) == ')' || s.charAt(i) == ']' || s.charAt(i) == '}') {
				if(st.empty()) return false;
				
				char c = st.pop();
				if(s.charAt(i) == ')' && c != '(') return false;
				if(s.charAt(i) == '}' && c != '{') return false;
				if(s.charAt(i) == ']' && c != '[') return false;
			}
		}
		if(st.isEmpty()) return true;

		return false;
    }
}
