// https://leetcode.com/problems/lru-cache

class LRUCache {
    class ListNode {
		ListNode prev;
		ListNode next;
		int val;
		int key;
		
		public ListNode(int v, int k) {
			val = v;
			key = k;
            prev = null;
            next = null;
		}
	}
    
    int capacity, size;
	HashMap<Integer, ListNode> map;
	private ListNode head, tail;

    public LRUCache(int c) {
        capacity = c;
        size=0;
        map = new HashMap<Integer, ListNode>();
        head = new ListNode(0,0);
        tail = new ListNode(0,0);
        head.prev=null;
        head.next=tail;
        tail.prev=head;
        tail.next=null;
    }
    
    public int get(int key) {
        if(capacity==0) return -1;
        
        if(map.containsKey(key)) {
            ListNode l =map.get(key);
            remove(l);
            moveToTail(l);
            return l.val;
        } else{
            return -1;
        }
    }
    
    public void put(int key, int val) {
        if(capacity==0) return;
        
        if(map.containsKey(key)){
            ListNode l = map.get(key);
            remove(l);
            l.val = val;
            moveToTail(l);
        } else{
            ListNode newNode = new ListNode(val, key);
            map.put(key, newNode);
			if(capacity == size) {
                map.remove(head.next.key);
                remove(head.next);
                moveToTail(newNode);
			} else {
                moveToTail(newNode);
                size++;
			}
        }
    }
    
    private void moveToTail(ListNode l) {
        l.prev=tail.prev;
        l.next= tail;
        tail.prev = l;
        l.prev.next = l;
    }
    private void remove(ListNode l) {
        l.next.prev = l.prev;
        l.prev.next = l.next;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
