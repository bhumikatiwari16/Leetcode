package priorityQueue;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KClosestPointsToOrigin {
	
	public static void main(String args[]) {
		
		int[][] points = {{3,3},{5,-1},{-2,4}};
		int k = 2;
		
		int[][] res = kClosest(points, k);
		
		System.out.println(Arrays.deepToString(res));
		
	}
	
	public static int[][] kClosest(int[][] points, int k) {
		
		PriorityQueue<P> pq = new PriorityQueue<P>();
        
		for (int i = 0; i < points.length; i++) {
				
				double temp = Math.sqrt(points[i][0] * points[i][0] + points[i][1] * points[i][1]); 
				P point = new P(points[i][0], points[i][1], temp);
				pq.offer(point);
				if (pq.size() > k) {
					pq.poll();
				}
				
		}
		
		int[][] res = new int[k][2];
		int i = 0;
		
		while (!pq.isEmpty()) {
			P cur = pq.poll();
			res[i][0] = cur.x;
			res[i][1] = cur.y;
			i++;
		}
		
		return res;
		
    }
	
	public static class P implements Comparable<P> {
		
		int x;
		int y;
		double dist;
		
		P(int xC, int yC, double d){
			x = xC;
			y = yC;
			dist = d;
		}

		@Override
		public int compareTo(P o) {
			
			 if (this.dist > o.dist) {
				 return -1;
			 } 
			 
			 else if (this.dist < o.dist) {
				 return 1;
			 }
			 
			 else return 0;
			
		}
	}

}
