package leetcode.strings;

public class StringRotation {

    public static void main(String[] args) {
        System.out.println(isStringRotate("waterbottle", "erbottlewta"));

    }

    public static boolean isStringRotate (String s1, String s2) {

        int l1 = s1.length();
        int l2 = s2.length();

        String s3 = s1.concat(s1);
        if (s3.contains(s2) && l1 == l2) {
            return true;
        }
            return false;

    }

    //or use the below method
    /*
    public boolean rotateString(String A, String B) {
        int l1 = A.length();
        int l2 = B.length();

        String s3 = B.concat(B);
        if (s3.contains(A) && l1==l2) {
            return true;
        }
        return false;
    }
*/
}
