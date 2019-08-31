// https://leetcode.com/problems/alien-dictionary

class Solution {
	
	boolean ACyclic(Map<Character, List<Character>> graph) {
		for(Map.Entry<Character, List<Character>> entry : graph.entrySet()) {
			for(Character c : entry.getValue()) {
				for(Character c1 : graph.get(c))
					if(c1 == entry.getKey()) return false;
			}
		}
		return true;
	}
	
	void topologicalSortRec(Map<Character, List<Character>> graph, Stack<Character> st, Map<Character, Boolean> visited, char key) {
		visited.put(key, true);
		
		for(Character c : graph.get(key)) {
			if(!visited.get(c)) topologicalSortRec(graph, st, visited, c);
		}
		
		st.push(key);
	}
	
	String topologicalSort(Map<Character, List<Character>> graph) {
		Map<Character, Boolean> visited = new HashMap<Character, Boolean>();
		Stack<Character> st = new Stack<>();
		
		for(Map.Entry<Character, List<Character>> entry : graph.entrySet()) {
			visited.put(entry.getKey(), false);
		}
		
		for(Map.Entry<Character, List<Character>> entry : graph.entrySet()) {
			if(!visited.get(entry.getKey()))
				topologicalSortRec(graph, st, visited, entry.getKey());
		}

		StringBuilder sb = new StringBuilder();
		while(!st.empty()) {
			sb.append(st.pop());
		}
		return sb.toString();
	}
	String alienSort(String[] dic) {
		Map<Character, List<Character>> graph = new HashMap<>();
		
		// initialize the graph with vertices
		for(int i=0; i<dic.length; i++) {
			int n=dic[i].length();
			for(int j=0; j<n; j++) {
				char c = dic[i].charAt(j);
				if(!graph.containsKey(c)) {
					graph.put(c, new ArrayList<Character>());
				}
			}
		}
		
		for(int i=0; i<dic.length-1; i++) {
			String s1 = dic[i];
			String s2 = dic[i+1];
			int len = Math.min(s1.length(), s2.length());

			for(int j=0; j<len; j++) {
				char c1 = s1.charAt(j);
				char c2 = s2.charAt(j);

				if(c1 != c2) {
					List<Character> l = graph.get(c1);
					l.add(c2);
					graph.put(c1, l);
					break;
				}
			}
		}

		if(ACyclic(graph))
			return topologicalSort(graph);
		else
			return "";
	}
}
