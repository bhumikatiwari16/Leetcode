package leetcode.strings;

public class StringCompression {

    public static void main(String[] args) {
        System.out.println(method2("aabbbccccddaabbbh"));
    }

    public static String compressString (String str) {

        int freq = 1;
        String res = "";
        Boolean last = false;

        for(int i = 0; i < str.length()-1; i++) {

            if (str.charAt(i) ==  str.charAt(i+1)) {
                freq++;
                if (i+2 == str.length()-1) {
                    if (str.charAt(i) ==  str.charAt(i+2)) {
                        freq++;
                        res = res.concat(""+ str.charAt(i+2) + freq);
                        return res;
                    } else {
                        res = res.concat(""+ str.charAt(i) + freq);
                        res = res.concat(""+str.charAt(i+2)+1);
                        return res;

                    }
                }
          //      last = false;
            } else {
                res = res.concat(""+ str.charAt(i) + freq);
                freq = 1;
           //     last = true;
            }
        }

      //  if (last == false) {
       //     res = res.concat("" + str.charAt(str.length() - 2) + freq);
      //  }


        if (res.length() >= str.length()) {
            return str;
        } else {
            return res;
        }
    }

    public static String method2 (String inp) {

        int i = 0, j = 0;
        int freq = 0;
        StringBuilder res = new StringBuilder();

        while(j < inp.length()) {
            if (inp.charAt(i) ==  inp.charAt(j)) {
                freq++;
                j++;
            } else {
                res.append(inp.charAt(i)).append(freq);
                i = j;
                freq=0;
            }
        }
        res.append(inp.charAt(i)).append(freq);

        String resStr = res.toString();

        if (resStr.length() >= inp.length()) {
            return inp;
        } else {
            return resStr;
        }
    }
}
