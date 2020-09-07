package leetcode.List;

import java.util.ArrayList;
import java.util.List;

public class VeritasManusg {
	List<String> l = new ArrayList<String>();
	String s = "bcd";
	l.add("0 0 L");
	rollingString(s, l);

}

public static String rollingString(String s, List<String> operations) {
    // Write your code here
        String temp=s;

        int length = s.length();

        for(String str : operations)
        {

            int leftIndex = Integer.parseInt(str.charAt(0)+"");
            System.out.println("Left Index "+ leftIndex);
            int rightIndex = Integer.parseInt(str.charAt(1)+"");
              System.out.println("Right Index "+ rightIndex);
            StringBuilder sb = new StringBuilder();
            sb.append(temp.substring(0,leftIndex));
            char op = str.charAt(2);
            if(op=='L'){
                int i=leftIndex;
                while(i<=rightIndex){
                    sb.append(Character.toString((char) (((str.charAt(i) - 'a' - 1) % 26) + 'a')));
                    i++;
                }
            }
            else{
                int i=leftIndex;
                while(i<=rightIndex){
                    sb.append(Character.toString((char) (((str.charAt(i) - 'a' + 1) % 26) + 'a')));
                     i++;
                }
               
            }

             sb.append(temp.substring(rightIndex+1,length));
             temp = sb.toString();

        }


        return temp;

    }

}
