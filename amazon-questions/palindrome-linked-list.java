// https://leetcode.com/problems/palindrome-linked-list

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverse(ListNode prev, ListNode cur) {
		if(cur==null) return prev;
		ListNode l = new ListNode(cur.val);
		l.next = prev;
		return reverse(l, cur.next);
	}
    
    public boolean isPalindrome(ListNode head) {
        ListNode newHead = reverse(null, head);
        while (head!=null) {
			if(head.val != newHead.val) return false;
			head = head.next;
			newHead = newHead.next;
		}
        return true;
    }
}
