package leetcode.Set;
import java.util.HashSet;
import java.util.Set;

public class HappyNumber {


    public static void main(String[] args) {

        int n =20;

        System.out.println(isHappy(n));

    }


    public static boolean isHappy(int n) {

        if(n==1)
            return true;
        if(n==0)
            return false;

         Set<Integer> set = new HashSet<>();

         return helper(n,set);

    }

    public static boolean helper(int n, Set<Integer> set){




        int sum = calc(n);

        if(set.contains(sum))
                return false;

        else if (sum == 1) {
            return  true;
        } else {

            set.add(sum);
            return helper(sum,set);
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
