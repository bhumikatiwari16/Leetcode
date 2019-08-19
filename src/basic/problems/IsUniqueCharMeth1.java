package basic.problems;

import java.util.HashMap;

public class IsUniqueCharMeth1 {

    public static void main(String[] args) {


        //System.out.println("amzon   " + isUniq("amzon"));
        IsUniqueCharMeth1 isUnique = new IsUniqueCharMeth1();
        System.out.println(isUnique.isUniq("Manishh"));
    }


    public  boolean isUniq(String inp) {

        HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
        for (int i = 0; i < inp.length(); i++) {
            char cur = inp.charAt(i);
            if (hm.containsKey(cur)) {
                return false;


            } else {
                hm.put(cur, 1);
            }
        }


        return true;
    }

}
