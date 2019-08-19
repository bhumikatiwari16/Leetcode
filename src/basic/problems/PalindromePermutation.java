package basic.problems;

import java.util.HashMap;

public class PalindromePermutation {

    public static void main(String[] args) {
        PalindromePermutation pp = new PalindromePermutation();
        System.out.println(pp.isPalindrome("tact coa"));
    }

    public boolean isPalindrome(String inp) {

        HashMap<Character,Integer> hm = new HashMap<Character, Integer>();
        for(int i = 0; i < inp.length(); i++) {
            if(inp.charAt(i) == ' ')
                continue;

            if (hm.containsKey(inp.charAt(i))) {
                hm.put(inp.charAt(i), (hm.get(inp.charAt(i)) + 1));
            } else {
                hm.put(inp.charAt(i), 1);
            }
        }

        int oddCheck = 0;

        for(HashMap.Entry<Character,Integer> entry: hm.entrySet()) {

            if (entry.getValue() % 2 == 0) {
                continue;
            } else {
                oddCheck++;
            }

            if (oddCheck > 1) {
                return false;
            }
        }

        return true;

    }

}
