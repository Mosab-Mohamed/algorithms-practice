// https://leetcode.com/problems/group-anagrams

class Solution {
    public boolean isAnagram(String s1, String s2) {
		if(s1.length() != s2.length()) return false;
		
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for (int i = 0; i < s1.length(); i++) {
			if(map.containsKey(s1.charAt(i))) {
				int count = map.get(s1.charAt(i));
				map.put(s1.charAt(i), count+1);
			} else map.put(s1.charAt(i), 1);
		}

		for (int i = 0; i < s2.length(); i++) {
			if(map.containsKey(s2.charAt(i))) {
				int count = map.get(s2.charAt(i));
				if(count == 1) {
					map.remove(s2.charAt(i));
					continue;
				}
				map.put(s2.charAt(i), count-1);
			} else return false;
		}
		return map.size() == 0;
	}
    
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs.length == 0 ) return new ArrayList<List<String>>();

		List<List<String>> sol = new ArrayList<List<String>>();
        for (int i = 0; i < strs.length; i++) {
        	boolean matched = false;
        	if(sol.size() == 0) {
        		List<String> list = new ArrayList<String>();
				list.add(strs[i]);
				sol.add(list);
				continue;
        	}
			for (int j = 0; j < sol.size(); j++) {
				if(isAnagram(strs[i], sol.get(j).get(0))) {
					sol.get(j).add(strs[i]);
					matched = true;
					break;
				}
			}
			if(!matched) {
				List<String> list = new ArrayList<String>();
				list.add(strs[i]);
				sol.add(list);
			}
		}
        
        return sol;
    }
}
