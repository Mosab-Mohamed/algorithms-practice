// https://leetcode.com/problems/sort-characters-by-frequency

class Solution {
    class Pair {
        int count;
        char c;
        Pair(int count, char c){
            this.c = c;
            this.count = count;
        }
    }
    public String frequencySort(String s) {
        if(s.length()==0) return s;

        Map<Character, Integer> map = new HashMap<Character, Integer>();
        
        int n=s.length();
        for(int i=0; i<n; i++){
            char c = s.charAt(i);
            if(map.containsKey(c)){
                int count = map.get(c);
                map.put(c, count+1);
            } else {
                map.put(c, 1);
            }
        }
        
        n = map.size();
        PriorityQueue<Pair> maxHeap = new PriorityQueue<Pair>(n, (a,b)->b.count-a.count);
        
        for (Map.Entry<Character, Integer> entry : map.entrySet()){
            maxHeap.add(new Pair(entry.getValue(), entry.getKey()));
        }
        
        StringBuilder sb = new StringBuilder();
        
        while(!maxHeap.isEmpty()){
            Pair p = maxHeap.poll();
            for(int i=0; i<p.count; i++){
                sb.append(p.c);
            }
        }
        
        return sb.toString();
    }
}
