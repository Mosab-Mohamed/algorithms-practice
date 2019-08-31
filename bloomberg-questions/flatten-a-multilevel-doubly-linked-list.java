https://leetcode.com/problems/flatten-a-multilevel-doubly-linked-list

/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;

    public Node() {}

    public Node(int _val,Node _prev,Node _next,Node _child) {
        val = _val;
        prev = _prev;
        next = _next;
        child = _child;
    }
};
*/
class Solution {
    public Node flatten(Node head) {
        if(head == null) return null;
        
        Stack<Node> st = new Stack<>();
        Node sol = head;
        
        while(!st.empty() || head.next!=null || head.child!=null) {
            if(head.child != null) {
                if(head.next != null) st.push(head.next);
                
                head.next = head.child;
                head.next.prev = head;
                head.child = null;
            } else {
                if(head.next == null && !st.empty()) {
                    head.next = st.pop();
                    head.next.prev = head;
                }
            }
            head = head.next;
        }

        return sol;
    }
}
