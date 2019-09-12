// https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    
    class Pair {
        int depth;
        TreeNode node;
        Pair(int _depth, TreeNode _node){
            depth = _depth;
            node = _node;
        }
    }
    
    public void addToSolution(List<List<Integer>> sol, Pair p){
        if( sol.size() >= p.depth+1 ){
            List<Integer> l = sol.get(p.depth);
            l.add(p.node.val);
        } else {
            List<Integer> l = new ArrayList<Integer>();
            l.add(p.node.val);
            sol.add(p.depth, l);
        }
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> sol = new ArrayList<List<Integer>>();
        
        if(root == null) return sol;

        Stack<Pair> helper = new Stack<>();
        Queue<Pair> q = new LinkedList<>();
        
        q.add(new Pair(0, root));
        
        while(!q.isEmpty()){
            Pair curr = q.poll();
            
            if(curr.node.left != null ) q.add(new Pair(curr.depth+1, curr.node.left));
            if(curr.node.right != null ) q.add(new Pair(curr.depth+1, curr.node.right));

            if(curr.depth % 2 == 0) {
                while(!helper.empty()){
                    addToSolution(sol, helper.pop());
                }
                addToSolution(sol, curr);
            } else {
                helper.add(curr);
            }
        }
        
        while(!helper.empty()){
            addToSolution(sol, helper.pop());
        }
        
        return sol;
    }
}
