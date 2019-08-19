package basic.problems;

import java.util.HashMap;

public class StringPermutation {

    public static void main(String[] args) {

        StringPermutation sp = new StringPermutation();
        System.out.println(sp.isStrPerm("balkh", "albkh"));
    }

    public boolean isStrPerm(String inp1, String inp2){

        //check for null and blank strings when both are being treated as valid inputs

        if(inp1==null || inp1.length()==0)
            return inp2==null|| inp2.length()==0;

        //check for unequal length input strings

        if(inp1.length() != inp2.length()){
            return false;
        }

        HashMap<Character,Integer> hm = new HashMap<Character, Integer>();

        for(int i = 0; i < inp1.length(); i++) {
         //   System.out.println(inp1.charAt(i));
            if (hm.containsKey(inp1.charAt(i))) {
                int temp = hm.get(inp1.charAt(i));
                hm.put(inp1.charAt(i), ++temp);
            } else {
                hm.put(inp1.charAt(i), 1);
            }
        }

        for(int j = 0; j < inp2.length(); j++) {
            if (hm.containsKey(inp2.charAt(j))) {
                int temp = hm.get(inp2.charAt(j));
                hm.put(inp2.charAt(j), --temp);
            } else {
                return false;
            }
        }


        for (Integer num: hm.values()) {
            if (num != 0) {
                return false;
            }
        }
        return true;
    }
}
