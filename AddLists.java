// https://leetcode.com/problems/add-two-numbers

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addLists(ListNode l1, ListNode l2, int carry) {
		if(l1==null && l2==null) {
			if(carry > 0) return new ListNode(carry);

			return null;
		}
		
		if(l1 == null) {
			if(l2.val + carry > 9) {
				ListNode l = new ListNode(0);
				l.next = addLists(l1, l2.next, 1);
				return l;
			}
            l2.val = l2.val + carry;
			return l2;
		}
		
		if(l2 == null) {
			if(l1.val + carry > 9) {
				ListNode l = new ListNode(0);
				l.next = addLists(l1.next, l2, 1);
				return l;
			}
            l1.val = l1.val + carry;
			return l1;
		}
		
		int sum = l1.val + l2.val + carry;
		ListNode l;
		
		if(sum > 9) {
			l = new ListNode(sum - 10);
			l.next = addLists(l1.next, l2.next, 1);
		} else {
			l = new ListNode(sum);
			l.next = addLists(l1.next, l2.next, 0);
		}
		return l;
    }

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
       return addLists(l1, l2, 0);
    }
}
