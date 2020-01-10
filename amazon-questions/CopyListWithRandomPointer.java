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
    public Node copy(Node head, HashMap<Node, Node> map) {
        if(head == null) return null;
        
        Node newNode = new Node(head.val, null, null);
        map.put(head, newNode);
        newNode.next = copy(head.next, map);
        newNode.random = map.get(head.random);
        return newNode;
    }

    public Node copyRandomList(Node head) {
        return copy(head, new HashMap<Node, Node>());
    }
}
