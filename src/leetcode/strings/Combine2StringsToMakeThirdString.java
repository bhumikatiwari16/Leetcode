package leetcode.strings;

import java.util.HashMap;

public class Combine2StringsToMakeThirdString {

    public static void main(String[] args) {

        System.out.println(IsCombination("aabcc", "dbbca","aadbbcbcac"));
        System.out.println(IsCombination("aabcc",  "dbbca", "aadbbbaccc"));

    }

    public static boolean IsCombination(String s1, String s2, String s3) {

        int l1 = s1.length();
        int l2 = s2.length();
        int l3 = s3.length();

        HashMap<Character,Integer> hm = new HashMap<Character, Integer>();
        for(int i = 0; i < l1; i++) {
            if (hm.containsKey(s1.charAt(i))){
                hm.put(s1.charAt(i),hm.get(s1.charAt(i))+1);
            } else {
                hm.put(s1.charAt(i),1);
            }
        }

        for(int j = 0; j < l2; j++) {
            if (hm.containsKey(s2.charAt(j))){
                hm.put(s2.charAt(j),hm.get(s2.charAt(j))+1);
            } else {
                hm.put(s2.charAt(j),1);
            }
        }

        for (int k = 0; k < l3; k++) {
            if (hm.containsKey(s3.charAt(k))) {
                hm.put(s3.charAt(k),hm.get(s3.charAt(k))-1);
            } else {
                return false;
            }

            if(hm.get(s3.charAt(k)) == 0) {
                hm.remove(s3.charAt(k));
            }
        }

        if (hm.size() == 0) {
            return true;
        } else {
            return false;
        }
    }
}
