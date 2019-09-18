https://leetcode.com/problems/word-ladder

class Solution {
    Set<String> visited = new HashSet<String>();

    boolean isOneChangeFar(String s1, String s2){
        int numOfChanges = 0;
        for(int i=0; i<s1.length(); i++){
            if(s1.charAt(i) != s2.charAt(i)){
                numOfChanges++;
                if(numOfChanges >= 2)
                    return false;
            }
        }
        return true;
    }
    
    void buildNodeGraph(String s1, Set<String> set, Map<String, List<String>> graph){
        boolean existInSet = false;
        if(set.contains(s1)){
            existInSet = true;
            set.remove(s1);
        }
        char[] word = s1.toCharArray();
        for(int i=0; i<word.length; i++){
            for(int j='a'; j<='z'; j++){
                if(j != (int) word[i]){
                    char tmp = word[i];
                    word[i] = (char) j;
                    String cur = new String(word);
                    if(set.contains(cur)){
                        List<String> l = graph.get(s1);
                        l.add(cur);
                    }
                    word[i]=tmp;
                }
            }
        }
        if(existInSet)
            set.add(s1);
    }
    
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Map<String, List<String>> graph = new HashMap<String, List<String>>();
        Set<String> set = new HashSet<>(wordList);
        
        for(String word : wordList) {
            graph.put(word, new ArrayList<String>());
            buildNodeGraph(word, set, graph);
        }
        
        Queue<String> q = new LinkedList<String>();
        
        for(String word : wordList) {
            if(isOneChangeFar(beginWord, word)){
                q.add(word);
            }
        }
        
        int level = 2;
        
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0; i<size; i++){
                String word = q.poll();
                if(endWord.equals(word))
                    return level;

                visited.add(word);
                for(String word1 : graph.get(word)){
                    if(!visited.contains(word1)){
                        q.add(word1);
                    }
                }
            }
            level++;
        }
        
        return 0;
    }
}
