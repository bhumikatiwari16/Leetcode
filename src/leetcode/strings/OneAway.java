package leetcode.strings;

public class OneAway {

    public static void main(String[] args) {
        OneAway oa = new OneAway();
        System.out.println(oa.StringEditsAway("apal", "apala"));
    }

    public boolean StringEditsAway(String s1, String s2) {

        if (s1.equals("") && s2.equals("")){
            return false;
        }


        int l1 = s1.length();
        int l2 = s2.length();
        int lenDiff = Math.abs(l1 - l2);

        int diff = 0;
        if (lenDiff == 0) {
            for (int i = 0; i < l1; i++) {
                if (s1.charAt(i) != s2.charAt(i)) {
                    diff++;
                }
            }
        } else if (lenDiff > 1) {
            return false;
        } else {
            int i = 0, j = 0;
            String st3;
            String st4;
            int min = 0;
            int max = 0;
            if (l1 > l2) {
                min = l2;
                max = l1;
                st3 = s2;
                st4 = s1;

            } else {
                min = l1;
                max = l2;
                st3 = s1;
                st4 = s2;
            }
            while (i < min && j < max) {
                if (st3.charAt(i) == st4.charAt(j)) {
                    i++;
                    j++;
                } else {
                    diff++;
                    j++;
                }
            }


        }
        if (diff > 1) {
            return false;
        } else
            return true;
    }
}
