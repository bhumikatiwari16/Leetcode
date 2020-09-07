package comparable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ReorderDataLogFile {

	public static void main(String[] args) {
		
		//String[] logs = {"dig1 8 1 5 1","let1 art can","let0 art can","dig2 3 6","let2 own kit dig","let3 art zero"};
		String[] logs = {"a1 9 2 3 1","g1 act car"};
		String[] result = reorderLogFiles(logs);
		
		for (String st: result) {
			
			System.out.println(st);
		
		}

	}
	
	public static String[] reorderLogFiles(String[] logs) {
		
		//Custom[] customs = new Custom[logs.length];
		
		String[] op = new String[logs.length];
		
		List<Custom> customs = new ArrayList<Custom>();
		
		int count = 0;
		
		for (String s: logs) {
			
			customs.add(new Custom(s));
		}
		
		Collections.sort(customs);
		
		for(Custom c: customs) {
			op [count]= c.s;
			count++;
		}
		
		return op;
		
	 } // end of reorder function
	
	static class Custom implements Comparable<Custom> {
		
		String s;
		
		
		public Custom(String st) {
			s = st;
		}

		@Override
		public int compareTo(Custom o) {
			
			String wrkStr = o.s;
			int i = 0;
			String ido = "";
			String idc = "";
			String logStro = "";
			String logStrc = "";
			
			boolean isAlphaLogo = true;
			boolean isAlphaLogc = true;
			
			ido = wrkStr.substring(0,wrkStr.indexOf(' '));
			idc = s.substring(0,s.indexOf(' '));
			
			logStro = wrkStr.substring(wrkStr.indexOf(' ')+1);
			logStrc = s.substring(s.indexOf(' ')+1);
			
			
			System.out.println("logStrc::" + logStrc);
			System.out.println("logStro::" + logStro);
			
			if ((logStro.charAt(0)<='9'))
				isAlphaLogo = false;

			if ((logStrc.charAt(0)<='9'))
				isAlphaLogc = false;
			
			
			if (!isAlphaLogc && !isAlphaLogo) {
				return 0;
			} else if (!isAlphaLogc && isAlphaLogo) {
				return 1;
			} else if (isAlphaLogc && !isAlphaLogo) {
				return -1;
			} else {
				if(logStrc.compareTo(logStro)==0) {
					return idc.compareTo(ido);
				}
				else
					return logStrc.compareTo(logStro);
					
			}
			
			
		}
	} //end of Custom class
	
}
