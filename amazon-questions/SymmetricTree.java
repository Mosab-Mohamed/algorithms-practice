// https://leetcode.com/problems/symmetric-tree

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
    public boolean checkIsSymmetric(TreeNode left, TreeNode right) {
		if(left == null && right==null) return true;
        else if(left == null || right ==null) return false;
        else if(left.val != right.val) return false;
        
        return checkIsSymmetric(left.right, right.left) && checkIsSymmetric(left.left, right.right);
	}
	
	public boolean isSymmetric(TreeNode root) {
        if(root ==null) return true;
        return checkIsSymmetric(root.left, root.right);
    }
}
