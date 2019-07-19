// https://leetcode.com/problems/merge-k-sorted-lists

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        int minIndex = -1;
        for (int i = 0; i < lists.length; i++) {
        	if(lists[i] != null && minIndex == -1 )
        		minIndex = i;
        	else if(lists[i] != null && minIndex != -1 && lists[i].val < lists[minIndex].val)
        		minIndex = i;
        }

        if(minIndex == -1) return null;

        ListNode min = lists[minIndex];
        lists[minIndex] = min.next;
        min.next = mergeKLists(lists);
        return min;
    }
}
