// https://leetcode.com/problems/most-common-word

class Solution {
    public String mostCommonWord(String paragraph, String[] bannedWords) {
		Set<String> banned = new HashSet<String>(Arrays.asList(bannedWords));
        Map<String, Integer> count = new HashMap<String, Integer>(); 
        
        String[] words = paragraph.split("[, ?.:;'!`#$%&*()]+");
        
        for(int i=0; i<words.length; i++){
            String word = words[i].toLowerCase();
            if(!banned.contains(word)){
                if(count.containsKey(word)) {
                    int wordCount = count.get(word);
                    count.put(word, wordCount+1);
                } else {
                    count.put(word, 1);
                }
            }
        }
        
        String maxWordCount = "";
        int maxCount=0;
        
        for(Map.Entry<String, Integer> word : count.entrySet()){
            if(word.getValue() > maxCount){
                maxWordCount = word.getKey();
                maxCount = word.getValue();
            }
        }
        
        return maxWordCount;
    }
}
