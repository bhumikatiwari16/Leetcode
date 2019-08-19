package basic.problems;

public class URLify {

    public static void main(String[] args) {

        System.out.println(url("   Mr   John  Smith          ", 13));
    }

    public static String url(String inp, int tru) {

        StringBuilder sb = new StringBuilder();

            for (int j = 0; j < tru; j++) {
                if (inp.charAt(j) != ' ') {
                    sb.append(inp.charAt(j));
                } else {
                    sb.append("%20");
                }
            }

        return sb.toString();
    }
}
