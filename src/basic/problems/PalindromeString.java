package basic.problems;

public class PalindromeString {

    public static void main(String[] args) {

        String str = "abcdcea";
        System.out.println("String "+ str+ " is Plaindrome "+ isPalindrome(str));


    }

    public static boolean isPalindrome(String str){

        if(str==null || str.length()==0)
            return true;

        int start=0;
        int end=str.length()-1;

        while(start<end){

            if(str.charAt(start)==str.charAt(end)){
                start++;
                end--;
            }
            else
                return false;
        }

        return true;
    }


}
