// https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii

/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val,Node _left,Node _right,Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/
class Solution {
    
    class Pair {
        Node n;
        int height;
        
        Pair(Node _n, int _height){
            this.n = _n;
            this.height = _height;
        }
    }

    public Node connect(Node root) {
        if(root == null) return root;

        Queue<Pair> q = new LinkedList<Pair>();
        q.add(new Pair(root, 0));
        
        while(!q.isEmpty()) {
            Pair curr = q.poll();
            if(curr.n.left != null) q.add(new Pair(curr.n.left, curr.height + 1));
            if(curr.n.right != null) q.add(new Pair(curr.n.right, curr.height + 1));
            
            if(q.peek() != null) {
                if(curr.height == q.peek().height) {
                    curr.n.next = q.peek().n;
                }
            }
        }
        
        return root;
    }
}
