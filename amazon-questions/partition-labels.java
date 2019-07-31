// https://leetcode.com/problems/partition-labels

class Solution {
    public List<Integer> partitionLabels(String S) {
        Map<Character, Integer> lastOcc = new HashMap<Character, Integer>();
        List<Integer> sol = new ArrayList<Integer>();
        
        for(int i=0; i<S.length(); i++){
            lastOcc.put(S.charAt(i), i);
        }
        
        int curr=0, size=1;
        
        while(curr<S.length()){
            int lastOccIndex = lastOcc.get(S.charAt(curr));
            boolean foundMax = false;
            for(int i=curr+1; i<=lastOccIndex; i++){
                size++;
                if(lastOcc.get(S.charAt(i)) > lastOccIndex) {
                    curr = i;
                    foundMax = true;
                    break;
                }
            }
            if(!foundMax){
                sol.add(size);
                curr = lastOccIndex+1;
                size=1;
            }
        }
        
        return sol;
    }
}
