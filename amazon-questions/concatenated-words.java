// https://leetcode.com/problems/concatenated-words

class TrieNode {
    boolean isLeaf;
    TrieNode[] children;
    
    TrieNode () {
        this.children = new TrieNode[26];
    }
}

class Solution {
    TrieNode trieRoot;
    
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        trieRoot = new TrieNode();
        
        for(int i=0; i<words.length; i++)
            addToTrie(words[i]);
        
        List<String> sol = new ArrayList<String>();
        
        for(int i=0; i<words.length; i++)
            if(isConcatenatedWord(words[i], 0, 0))
                sol.add(words[i]);
        
        return sol;
    }
    
    boolean isConcatenatedWord(String s, int start, int count) {
        int n = s.length();
        
        if(start >= n)
            return false;
        
        TrieNode iterator = trieRoot;
        for(int i=start; i<n; i++) {
            int index = s.charAt(i) - 'a';

            if(iterator.children[index] == null) return false;
            
            if(iterator.children[index].isLeaf) {
                if(isConcatenatedWord(s, i+1, count+1))
                    return true;
            }
            
            iterator = iterator.children[index];
        }
        
        if(!iterator.isLeaf)
            return false;
        
        return count >= 1;
    }
    
    void addToTrie(String s) {
        int n = s.length();
        
        TrieNode iterator = trieRoot;
        
        for(int i=0; i<n; i++) {
            int index = s.charAt(i) - 'a';
            if(iterator.children[index] == null)
                iterator.children[index] = new TrieNode();
            
            iterator = iterator.children[index];
        }
        iterator.isLeaf = true;
    }
}
