package basic.problems;

public class IsUniqueCharMeth2 {

    public static void main(String[] args) {


        //System.out.println("amzon   " + isUniq("amzon"));
        IsUniqueCharMeth1 isUnique = new IsUniqueCharMeth1();
        System.out.println(isUnique.isUniq("Manish"));
    }


    public boolean isUniq(String inp) {

        for (int i = 0; i < inp.length(); i++) {
            for (int j = i + 1; j < inp.length(); j++) {

                if (inp.charAt(i) == inp.charAt(j)) {
                    return false;
                }
            }
        }
        return true;
    }
}
