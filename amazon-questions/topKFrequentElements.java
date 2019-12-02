// https://leetcode.com/problems/top-k-frequent-elements

class Solution {
    class Pair {
        private int key;
        private int val;
        Pair(int _k, int _v) {
            this.key = _k;
            this.val = _v;
        }
        
        int getKey() {
            return this.key;
        }
        
        int getVal() {
            return this.val;
        }
    }

    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap();
        for(int i=0; i<nums.length; i++){
            if(map.containsKey(nums[i])){
                int count = map.get(nums[i]);
                map.put(nums[i], count+1);
            } else {
                map.put(nums[i], 1);
            }
        }
        
        Queue<Pair> pq = new PriorityQueue<Pair>((a,b)->b.getVal()-a.getVal());
        
        for(Map.Entry<Integer, Integer> e : map.entrySet()){
            pq.add(new Pair(e.getKey(), e.getValue()));
        }
        
        List<Integer> sol = new ArrayList<Integer>();
        for(int i=0; i<k; i++){
            sol.add(pq.poll().getKey());
        }
        return sol;
    }
}
