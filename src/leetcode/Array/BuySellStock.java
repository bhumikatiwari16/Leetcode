package leetcode.Array;

public class BuySellStock {

	public static void main(String[] args) {
		
		System.out.println(maxProfit(new int[] {7,1,5,3,6,4}));
		
		System.out.println(maxProfit(new int[] {7,6,4,3,1}));
	}

	 public static int maxProfit(int[] prices) {
	     
		 int minPrice = Integer.MAX_VALUE;
		 int maxProfit = 0;
		 int i = 0;
		 
		 while(i < prices.length) {
			 
			 if (prices[i] < minPrice) {
				 minPrice = prices[i];
			 }
			 
			 if (prices[i]-minPrice > maxProfit) {
				 maxProfit = prices[i]-minPrice;
			 }
			 
			 i++;
		 }
		 
		 return maxProfit;
		 
	    }
	 
}
