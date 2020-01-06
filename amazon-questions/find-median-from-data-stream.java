// https://leetcode.com/problems/find-median-from-data-stream

class MedianFinder {

    PriorityQueue<Integer> maxQ;
    PriorityQueue<Integer> minQ;
    /** initialize your data structure here. */
    public MedianFinder() {
        maxQ = new PriorityQueue<Integer>((a,b) -> b-a);
        minQ = new PriorityQueue<Integer>();
    }
    
    public void addNum(int num) {
        maxQ.offer(num);
        minQ.offer(maxQ.poll());
        if(maxQ.size() < minQ.size()){
            maxQ.offer(minQ.poll());
        }
    }
    
    public double findMedian() {
        if(maxQ.size() > minQ.size()) return maxQ.peek();
        return  ( maxQ.peek() + minQ.peek() ) / 2.0;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
