// https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree

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
    TreeNode sol = null;

    public void buildPath(TreeNode root, Set<TreeNode> s, TreeNode p){
        if(root==null) return;
        
        if(p == root) {
            s.add(p);
            return;
        } else {
            buildPath(root.left, s, p);
            buildPath(root.right, s, p);
            if(s.contains(root.left) || s.contains(root.right)) s.add(root);
        }
    }
    
    public TreeNode getLwestCommonAncestor(TreeNode root, Set<TreeNode> pPath, TreeNode q){
        if(root==null) return null;
	        
	        if(q == root) {
	            if(pPath.contains(q)) sol = q;
	            return root;
	        } else {
	            if( getLwestCommonAncestor(root.left, pPath, q)!=null || getLwestCommonAncestor(root.right, pPath, q)!=null) {
	            	if(pPath.contains(root) && sol==null) sol = root;
	            	return root;	            
	            }
	        }
	        
	        return null;
    }
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null || p==null || q==null) return null;

        HashSet<TreeNode> pPath = new HashSet<TreeNode>();
        buildPath(root, pPath, p);
        getLwestCommonAncestor(root, pPath, q);
        return sol;
    }
}
