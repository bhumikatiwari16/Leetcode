package basic.problems;

public class URLifyMeth2 {

    public static void main(String[] args) {

        url("Mr John Smith    ", 13);
     //   System.out.println(url("   Mr   John  Smith ", 13));
    }

    public static void url(String inp, int tru) {

        char[] inp1 = inp.toCharArray();

        int z = tru-1;
        int l = inp1.length-1;

        System.out.println(z);
        System.out.println(l);

        while(z > 0){

            if (inp1[z] != ' ') {
                inp1[l] = inp1[z];
                l--;
                z--;
            }
            else {
                inp1[l] = '0';
              inp1[l-1] = '2';
               inp1[l-2] = '%';
               l = l-3;
               z--;
           }
        }

        System.out.println(inp1);


    }
}