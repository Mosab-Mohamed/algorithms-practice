// https://leetcode.com/problems/lfu-cache

class Node {
    int key;
    int value;
    int freq;

    Node(int k, int v) {
        this.key = k;
        this.value = v;
        this.freq = 1;
        
    }
}

class LFUCache {
    HashMap<Integer, Node> cache;
    HashMap<Integer, LinkedHashSet> cacheOrder;
    int cap;
    int leastFreq;
    int size;

    public LFUCache(int capacity) {
        cache = new HashMap<Integer, Node>();
        cacheOrder = new HashMap<Integer, LinkedHashSet>();
        this.cap = capacity;
        this.size = 0;
        this.leastFreq = Integer.MAX_VALUE;
    }
    
    public int get(int key) {
        Node n = cache.get(key);

        if(n == null) {
            return -1;
        }
        
        incrementFreq(n);
        
        return n.value;
    }
    
    public void put(int key, int val) {
        if(this.cap == 0) return;
        
        Node n = cache.get(key);
        if(n != null){
            n.value = val;
            incrementFreq(n);
            return;
        }

        n = new Node(key, val);

        if(this.size == this.cap) {
            LinkedHashSet leastFreqSet = cacheOrder.get(this.leastFreq);
            
            int leastFreqKey = (int) leastFreqSet.iterator().next();
            
            leastFreqSet.remove(leastFreqKey);
            cache.remove(leastFreqKey);
            
            if(n.freq < this.leastFreq) {
                this.leastFreq = n.freq;
            }
            addToFreqMap(n);
        } else {
            if(n.freq < this.leastFreq) {
                this.leastFreq = n.freq;
            }

            addToFreqMap(n);
            size++;
        }
        cache.put(key, n);
    }
    
    private void incrementFreq(Node n) {
        LinkedHashSet freqSet = cacheOrder.get(n.freq);
        
        if(this.leastFreq == n.freq && freqSet.size() == 1) {
            this.leastFreq++;
        }
        
        freqSet.remove(n.key);

        n.freq += 1;
        addToFreqMap(n);
    }
    
    private void addToFreqMap(Node n) {
        LinkedHashSet freqSet = cacheOrder.get(n.freq);

        if(freqSet == null) {
            freqSet = new LinkedHashSet<Integer>();
            cacheOrder.put(n.freq, freqSet);
        }
        
        freqSet.add(n.key);
    }
    
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
