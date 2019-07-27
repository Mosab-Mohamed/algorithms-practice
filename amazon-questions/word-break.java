// https://leetcode.com/problems/word-break

class Solution {
    HashMap map  = new HashMap<String, Boolean>();
    public boolean checkExist(String s, int start, Set<String> dic) {
		if(start == s.length()) return true;
		if(map.containsKey(s.substring(start+1))) return (boolean) map.get(s.substring(start+1));
		for (int i = start; i < s.length(); i++) {
			if(dic.contains(s.substring(start, i+1))) {
				if(checkExist(s, i+1, dic))
					return true;
			}
		}
		map.put(s.substring(start+1), false);
		return false;
	}
    
    public boolean wordBreak(String s, List<String> wordDict) {
        if(s.length()==0) return false;
        if(wordDict.size()==0) return false;

		Set<String> set = new HashSet<String>(wordDict);

		return checkExist(s, 0, set);
    }
}
