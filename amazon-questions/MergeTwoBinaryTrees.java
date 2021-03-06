// https://leetcode.com/problems/merge-two-binary-trees

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
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if(t1==null && t2==null) return null;
		if(t1 ==null) {
			TreeNode t = new TreeNode(t2.val);
			t.left = mergeTrees(t1, t2.left);
			t.right = mergeTrees(t1, t2.right);
			return t;
		}
		if(t2 ==null) {
			TreeNode t = new TreeNode(t1.val);
			t.left = mergeTrees(t1.left, t2);
			t.right = mergeTrees(t1.right, t2);
			return t;
		}
		
		TreeNode t = new TreeNode(t1.val + t2.val);
		t.left = mergeTrees(t1.left, t2.left);
		t.right = mergeTrees(t1.right, t2.right);
		return t;
    }
}
