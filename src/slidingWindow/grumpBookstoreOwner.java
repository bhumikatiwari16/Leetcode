package slidingWindow;

public class grumpBookstoreOwner {

	public static void main(String[] args) {
		
		int[] customers = new int[] {4,10,10};
		int[] grumpy = new int[] {1,1,0};
		int x = 2;
		System.out.println(maxSatisfied(customers, grumpy, x));
		
	}

	static int maxSatisfied(int[] customers, int[] grumpy, int x) {
       
		int windowStart = 0;
		int currentSum = 0;
		int maxSum = Integer.MIN_VALUE;
		//int fStart = 0, fEnd = 0;
		int numSatisfiedCustomers = 0;
		
		for(int i = 0; i < customers.length; i++){
            if(grumpy[i]==0){
                numSatisfiedCustomers += customers[i];
                customers[i] = 0;
            }
        }
		
		
		for (int windowEnd = 0; windowEnd < customers.length; windowEnd++) {
			currentSum += customers[windowEnd];
			
			if (windowEnd >= x-1) {
				maxSum = Math.max(maxSum, currentSum);
				
		//		fStart = windowStart;
		//		fEnd = windowEnd;
				
				currentSum -= customers[windowStart];
				windowStart++;
				
			}
				
			}
		
		return numSatisfiedCustomers+maxSum;
			
		}
	}
		
		//System.out.println(fStart+ " " + fEnd);
		/*
		int i = 0; int remSum = 0;
		
		if (fStart > 0 && fEnd == customers.length-1) {
			while(i < fStart ) {
				if (grumpy[i] == 0)
					remSum += customers[i];
					i++;
			}
		} else if (fStart == 0 && fEnd < customers.length-1) {
			while(i < customers.length) { 
				if (grumpy[i] == 0)
					remSum += customers[fEnd + i + 1];
					i++;
			} 
		}
		else if (fStart > 0 && fEnd < customers.length-1) {
			while(i < fStart) { 
				if (grumpy[i] == 0)
					remSum += customers[fEnd + i + 1];
					i++;
			}
			i = fEnd;
			while(i < customers.length) { 
				if (grumpy[i] == 0)
					remSum += customers[fEnd + i + 1];
					i++;
			}
		}
		
		int totCust = maxSum + remSum;
		
		return totCust;
		
    }
    */

