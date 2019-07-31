// https://leetcode.com/problems/k-closest-points-to-origin

class Solution {
    class PointDistance {
        double dist;
        int index;
        PointDistance(double dist, int index){
            this.dist = dist;
            this.index= index;
        }
    }
    public int[][] kClosest(int[][] points, int K) {
        
    	PriorityQueue<PointDistance> heap = new PriorityQueue<PointDistance>(points.length, (p1,p2)-> p1.dist > p2.dist ? 1:-1);
        
        for(int i=0; i<points.length; i++){
            heap.add(new PointDistance(Math.sqrt( (points[i][0]*points[i][0]) + (points[i][1]*points[i][1]) ), i));
        }
        
        int[][] sol= new int[K][2];
        for(int i=0; i<K; i++){
            sol[i] = points[heap.poll().index];
        }
        
        return sol;
    }
}
