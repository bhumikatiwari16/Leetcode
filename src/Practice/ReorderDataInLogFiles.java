package Practice;

import java.util.ArrayList;
import java.util.Arrays;

import java.util.Comparator;


public class ReorderDataInLogFiles {

	public static void main(String[] args) {
		
		String[] logs = {"dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"};
		
		printLogs(reorderLogFiles(logs));
		
	}

	
	public static String[] reorderLogFiles(String[] logs) {
		
		Arrays.sort(logs, new Comparator<String>() {
				
			@Override
			public int compare(String o1, String o2) {
				
				int spaceOne = o1.indexOf(" ");
				int spaceTwo = o2.indexOf(" ");
				char chOne = o1.charAt(spaceOne + 1);
				char chTwo = o2.charAt(spaceTwo + 1);
				
				if (Character.isDigit(chOne) &&  Character.isDigit(chTwo)) {
					return 0;
				} else if (!Character.isDigit(chOne) &&  Character.isDigit(chTwo)) {
					return -1;
				} else if (Character.isDigit(chOne) &&  !Character.isDigit(chTwo)) {
					return 1;
				}
				
				String stringOne = o1.substring(spaceOne+1);
				String stringTwo = o2.substring(spaceTwo+1);
				int stringCompare = stringOne.compareTo(stringTwo);
				
				if(stringCompare == 0) {
					String idOne = o1.substring(0,spaceOne);
					String idTwo = o2.substring(0,spaceTwo);
					int idCompare = idOne.compareTo(idTwo);
					return idCompare;
				}
				
				
				return stringCompare;
			}
        
		}
		
	);
	
	return logs;
	
	}
	
	public static void printLogs(String[] logs) {
		
		for (int i = 0; i < logs.length; i++) {
			
			System.out.println(logs[i]);
			
		}
		
	}

}
