package hashset;

import java.util.ArrayList;
import java.util.List;

public class HappyNumber {

	
	public static void main( String args[]) {
		
		System.out.println(isHappy(19));
		System.out.println(isHappy(18));
	}
	
	public static boolean isHappy(int n) {
		
		if(n==1)
            return true;
        if(n==0)
            return false;

         List<Integer> lst = new ArrayList<>();

         return helper(n,lst);
		
	}
	
	public static boolean helper(int n, List<Integer> lst){

        int sum = calc(n);

        if(lst.contains(sum))
                return false;

        else if (sum == 1) {
            return  true;
        } else {

            lst.add(sum);
            return helper(sum,lst);
        }


    }

    public static int calc (int num){
        int d = 0, sum = 0;
        while (num != 0) {
            d = num % 10;
            sum += Math.pow(d,2);
            num /= 10;
        }
        return sum;
    }

}

