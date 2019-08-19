package basic.problems;


// 0 1 1 2 3 5 8 13 21
public class Fibonacci {

    public static void main(String[] args) {
        System.out.println(printFib(8));

    }

    public static int printFib(int num) {

        if(num==0)
            return 0;

       else if(num==1)
            return 1;

        return  printFib(num-1)+ printFib(num-2);

        }


}
