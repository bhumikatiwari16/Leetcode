package comparable;

public class AlienDictVerify {

	public static void main(String[] args) {
String[] words = new String[2];
words[0] = "hello";
words[1]="leetcode";
		//String[] words = { "hello", "leetcode" };
		String order = "hlabcdefgijkmnopqrstuvwxyz";

		System.out.println(isAlienSorted(words, order));

		String[] word1 = { "word", "world", "row" };
		String order1 = "worldabcefghijkmnpqstuvxyz";
		

		System.out.println(isAlienSorted(word1, order1));
		
		String[] word2 = {"apple","app"};
		String order2= "abcdefghijklmnopqrstuvwxyz";
		System.out.println(isAlienSorted(word2, order2));

	}

	public static boolean isAlienSorted(String[] words, String order) {
		
		Custom[] customs = new Custom[words.length];
		
		for(int i=0;i<words.length;i++)
		{
			customs[i] = new Custom(words[i], order);
		}
		
		for(int i=0;i<customs.length-1;i++) {
			
			if(customs[i].compareTo(customs[i+1])>0)
				return false;
		}

		return true;
	}

	static class Custom implements Comparable<Custom> {

		String str1;
		String order1;

		public Custom(String str, String order) {
			str1 = str;
			order1 = order;
		}

		@Override
		public int compareTo(Custom o) {
			
			String str2 = o.str1;
			int len = Math.min(str1.length(), str2.length());
			for (int i = 0; i < len; i++) {
				char ch1 = str1.charAt(i);
				int index1 = order1.indexOf(ch1);

				char ch2 = str2.charAt(i);
				int index2 = order1.indexOf(ch2);

				if (index1 > index2) {
					return 1;
				} else if (index1 < index2) {
					return -1;
				}
			}

			if (str1.length() > str2.length())
				return 1;
			else if (str1.length() == str2.length())
				return 0;
			else {
				return -1;
			}

		}

	}

}
