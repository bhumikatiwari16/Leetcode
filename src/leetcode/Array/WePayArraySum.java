package leetcode.Array;

import java.util.ArrayList;
import java.util.List;

public class WePayArraySum {

	public static void main(String[] args) {

		List<Integer> inputs = new ArrayList<Integer>();
		List<Integer> tests = new ArrayList<Integer>();

		inputs.add(-1);
		inputs.add(1);
		inputs.add(5);

		tests.add(3);
		tests.add(7);
		tests.add(2);

		boolean o = arraySum(inputs, tests);

		System.out.println(o);

	}

	public static boolean arraySum(List<Integer> inputs, List<Integer> tests) {

		// Initializing two integer variables to hold sizes for inputs arraylist and
		// tests arraylist
		int iSize = inputs.size();
		int tSize = tests.size();
		int sum = 0;

		/*
		 * 1) Verifying boundary condition when inputs arraylist has only single element
		 * 2) Verifying boundary condition when tests arraylist has no elements Expected
		 * output: arraySum function returns false in both conditions.
		 */

		if (iSize == 1 || tSize == 0) {
			return false;
		}

		/*
		 * Logic: Every element in inputs arrayList summed with subsequent elements of
		 * inputs arrayList
		 */

		for (int i = 0; i < iSize; i++) {

			// Edge condition handled:
			// When last element of inputs array reached and there are no elements after
			// that to calculate sum
			// Expected output: function return false
			if (i == iSize - 1) {
				return false;
			}

			for (int j = i + 1; j < iSize; j++) {

				sum = inputs.get(i) + inputs.get(j);

				/*
				 * Check if tests arraylist contains an element with the value same as sum If
				 * true, function returns true else check for next value in inputs arraylist and
				 * reset sum to 0
				 */

				if (tests.contains(sum)) {
					return true;
				} else {
					sum = 0;
				}

			}

		}

		// No two elements of input found to sum upto an element in tests arraylist
		// Function returns false
		return false;

	}

}
