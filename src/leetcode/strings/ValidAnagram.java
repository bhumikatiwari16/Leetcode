package leetcode.strings;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;


public class ValidAnagram {

    public static void main(String[] args) {
        System.out.println(isAnagram("anagtam", "nbgbram"));
    }

    public static boolean isAnagram(String s, String t) {

        boolean flag = false;
        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();

        if (s == null) {
            return false;
        }

        if (s.length() != t.length()) {
            return false;
        }

        if (s.length() == 0) {
            return t.length()==0;
        }

        // manish

        for (char c : s.toCharArray()) {   // for (int i=0 ;i< s.length;i++)
            if (map1.containsKey(c)) {
              //  System.out.println("1st loop if");
                map1.put(c, (map1.get(c)) + 1);
            } else {
               // System.out.println("1st loop else");
                map1.put(c, 1);
            }
        }

        for (char c : t.toCharArray()) {   // for (int i=0 ;i< s.length;i++)
            if (map2.containsKey(c)) {
             //   System.out.println("2nd loop if");
                map2.put(c, (map2.get(c)) + 1);
            } else {
             //   System.out.println("2nd loop else");
                map2.put(c, 1);
            }
        }

        for (Map.Entry<Character, Integer> entry1 : map1.entrySet()) {
            char key = entry1.getKey();
            if (!map2.containsKey(key)) {
                return false;
            } else {

                int freq = entry1.getValue();
                if (map2.get(key) != freq) {
                    return false;
                }
            }
        }


        return true;
    }
}
