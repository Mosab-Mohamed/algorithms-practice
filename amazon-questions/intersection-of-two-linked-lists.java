// https://leetcode.com/problems/intersection-of-two-linked-lists

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    HashSet<ListNode> set = new HashSet<ListNode>();
    
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null;
        while(headA!=null){
            set.add(headA);
            headA= headA.next;
        }
        
        while(headB!=null){
            if(set.contains(headB)) return headB;
            headB= headB.next;
        }
        
        return null;
    }
}
