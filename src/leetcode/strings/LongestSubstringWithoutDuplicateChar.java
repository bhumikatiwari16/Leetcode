package leetcode.strings;

import java.util.HashMap;

public class LongestSubstringWithoutDuplicateChar {

    public static void main(String[] args) {
        System.out.println(findLongestSubstr("abcdbeacidd"));

    }

    public static int findLongestSubstr (String str) {

        int max = 1;
        int i = 0, j = 0;

        if (str == "") {
            return 0;
        }

        HashMap<Character,Integer> hm = new HashMap<Character, Integer>();

        while (i < str.length() && j < str.length()) {

            char val = str.charAt(i);
            if (hm.containsKey(val)) {
                j = Math.max(j, hm.get(str.charAt(i))+1);

            }
                hm.put(val, i);
                max = Math.max(max, i-j+1);
                i++;
        }
        return max;
    }
}
