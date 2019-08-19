package leetcode.strings;

import javax.swing.text.html.HTMLDocument;
import java.util.HashMap;
import java.util.Iterator;

public class MaxRepeatedChar {

    public static void main(String[] args) {
        System.out.println(findMaxRepeatedChar("aassssssbbbbbbbbbbbddd"));
    }

    public static char findMaxRepeatedChar (String str) {

        char rep = ' ';
        int i = 0;
        int max = 1;

        HashMap<Character,Integer> hm = new HashMap<Character,Integer>();

        while (i < str.length()) {
            if (hm.containsKey(str.charAt(i))) {
                hm.put(str.charAt(i), hm.get(str.charAt(i)) + 1);
                if (max < hm.get(str.charAt(i))) {
                    max = hm.get(str.charAt(i));
                    rep = str.charAt(i);
                }
            } else {
                hm.put(str.charAt(i), 1);
            }

            i++;
        }

        /*
        i = 0;

        Iterator hmI = hm.entrySet().iterator();

        while (hmI.hasNext()){
            HashMap.Entry ent = (HashMap.Entry) hmI.next();
            int curFreq = (int)ent.getValue();
            char curChar = (char)ent.getKey();
            if (curFreq > max) {
                max = curFreq;
                rep = curChar;
            }
        }


         */

        System.out.println(max);

        return rep;
    }
}
