package leetcode.strings;

/*

Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.

Examples:

s = "leetcode"
return 0.

s = "loveleetcode",
return 2.
Note: You may assume the string contain only lowercase letters.


 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class FirstUniqueCharacterInAString {

    public static void main(String[] args) {

        System.out.println(firstUniqChar("cc"));
    }

    /*

    public  static int firstUniqChar(String s) {

        boolean flag = false;
        //int k;
        for (int i = 0; i < s.length(); i++) {
            if (s.length() != 2) flag = false;
            for (int j = i + 1; j < s.length(); j++) {
            //    if ((i-1) > 0) { k = i-1;} else k = 0;
              //  System.out.println((s.substring(0,k)).contains(""+s.charAt(i)));
                if (s.charAt(i) == s.charAt(j)) {
                  // System.out.println(i + "        " + j);
                    flag = true;
                }
            }
         //   System.out.println(flag);
                if (flag == false) {
                    return i;
                }
        }
        return -1;
    }

     */

    public static int firstUniqChar(String s) {

        ArrayList<Character> visited = new ArrayList<>();
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {

            if (!visited.contains(s.charAt(i))) {
                visited.add(s.charAt(i));
                map.put(s.charAt(i), i);
            } else {
                if (map.containsKey(s.charAt(i))) {
                    map.remove(s.charAt(i));
                }
            }
        }
int min= Integer.MAX_VALUE;

        for(Map.Entry<Character,Integer> entry:map.entrySet()){

            min = Math.min(min,entry.getValue());
        }

        if(min!=Integer.MAX_VALUE)
            return min;

        return -1;
    }


}