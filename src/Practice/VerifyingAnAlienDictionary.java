package Practice;

import java.util.Arrays;
import java.util.Comparator;

public class VerifyingAnAlienDictionary {

	public static void main(String[] args) {

		String[] words = new String[] { "word","world","row" };
		String order = "worldabcefghijkmnpqstuvxyz";

		System.out.println(isAlienSorted(words, order));

	}

	public static boolean isAlienSorted(String[] words, String order) {

		Custom[] custom = new Custom[words.length];

		for (int i = 0; i < words.length; i++) {

			custom[i] = new Custom(words[i], order);

		}

		Arrays.sort(custom, new Comparator<Custom>() {

			@Override
			public int compare(Custom o1, Custom o2) {
				String w1 = o1.word;
				String w2 = o2.word;

				if (w1 == w2) {
					return 0;
				}

				int comLen = Math.min(w1.length(), w2.length());
				int j = 0;

				while (j < comLen) {

					char ch1 = w1.charAt(j);
					char ch2 = w2.charAt(j);

					int pos1 = order.indexOf(ch1);
					int pos2 = order.indexOf(ch2);

					if (pos1 == pos2) {
						j++;
					} else if (pos1 > pos2) {
						return 1;
					} else {
						return -1;
					}

				}

				if (w1.length() > comLen) {
					return 1;
				}

				return -1;

			}
		});

		for (int i = 0; i < words.length; i++) {

			Custom c = custom[i];

			if (!c.word.equals(words[i])) {
				return false;
			}

		}

		return true;

	}

	static class Custom {

		String word;
		String order;

		public Custom(String word, String order) {

			this.word = word;
			this.order = order;

		}
		
	
	}

}
