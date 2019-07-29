// https://leetcode.com/problems/gray-code

class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> sol = new ArrayList();
        
        for(int i =0;i< Math.pow(2,n);i++){
            sol.add(i ^ (i/2));
        }
        
        return sol;
    }
}
