package stack;

/*
 * https://www.geeksforgeeks.org/the-stock-span-problem/
 * 
 * The stock span problem is a financial problem where we have a series of n daily price 
quotes for a stock and we need to calculate span of stock’s price for all n days. 
The span Si of the stock’s price on a given day i is defined as the maximum number of 
consecutive days just before the given day, for which the price of the stock on the 
current day is less than or equal to its price on the given day.
For example, if an array of 7 days prices is given as {100, 80, 60, 70, 60, 75, 85}, 
then the span values for corresponding 7 days are {1, 1, 1, 2, 1, 4, 6} 
 * 
 * 
 */

import java.util.Stack;

public class stockSpan {

	class Pair {

		int index;
		int value;

		public Pair(int index, int value) {

			this.index = index;
			this.value = value;
		}

	}

	public static void main(String[] args) {

		int[] arr = { 80,56,60,10,20,75,90 };

		int[] res = findStockSpan(arr);

		for (int i = 0; i < res.length; i++) {

			System.out.println(res[i]);

		}

	}

	public static int[] findStockSpan(int[] arr) {

		stockSpan ss = new stockSpan();
				
		int[] res = new int[arr.length];

		int[] resFinal = new int[arr.length];
		
		Stack<Pair> s = new Stack<Pair>();

		for (int i = 0; i < arr.length; i++) {

			while (!s.isEmpty() && s.peek().value < arr[i]) {
				s.pop();
			}

			if (s.isEmpty()) {

				res[i] = -1;

			}

			else {

				res[i] = s.peek().index;

			}

			stockSpan.Pair p = ss.new Pair(i, arr[i]);
			s.push(p);

		}
		
		for (int i = 0; i < arr.length; i++) {
			
			resFinal[i] = i - res[i];
			
		}

		return resFinal;

	}

}
