// https://leetcode.com/problems/copy-list-with-random-pointer

/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;
    public Node random;

    public Node() {}

    public Node(int _val,Node _next,Node _random) {
        val = _val;
        next = _next;
        random = _random;
    }
};
*/
class Solution {
  
    HashMap<Node, Node> map = new HashMap<Node, Node>();
    
    public Node copy(Node head) {
        if(head == null) return null;
        
        Node newNode = new Node(head.val, null, null);
        newNode.next = copy(head.next);
        map.put(head, newNode);
        return newNode;
    }

    public Node copyRandomList(Node head) {
        Node newHead = copy(head);
        Node ans = newHead;
        
        while(newHead!=null){
            newHead.random = map.get(head.random);
            newHead = newHead.next;
            head = head.next;
        }
        
        return ans;
    }
}
