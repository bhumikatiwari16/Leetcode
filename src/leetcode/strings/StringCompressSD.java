package leetcode.strings;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class StringCompressSD {

    public static void main(String[] args) {

        System.out.println(compressString("aaaaabbbkkkkkkkllaagggg"));
    }

    public static String compressString(String st1) {

        StringBuilder sb = new StringBuilder();
      //  HashMap<Character, Integer> hm = new HashMap<Character, Integer>();

        int i = 0, j = 0, freq = 0;

        while (i < st1.length() && j < st1.length()) {
            if (st1.charAt(i) == st1.charAt(j)) {
                freq++;
            } else {
                sb.append(st1.charAt(j)).append(freq);
                j = i;
                freq = 1;
            }
        /*       if (hm.containsKey(st1.charAt(i))) {
                    hm.put(st1.charAt(i), hm.get(st1.charAt(i))+1);

                }  else {
                    hm.put(st1.charAt(i), 1);
                }
            } else {
                sb.append(st1.charAt(j)).append(hm.get(st1.charAt(j)));
                hm.remove(st1.charAt(j));
                hm.put(st1.charAt(i), 1);
                j = i;
            }
         */
            i++;
        }

       sb.append(st1.charAt(j)).append(freq);

        return sb.toString();
    }
}