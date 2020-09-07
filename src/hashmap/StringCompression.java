package hashmap;

public class StringCompression {

	public static void main(String args[]) {
		
		char[] chars = {'a','a','b','b','c','c','c'};
		System.out.println(compress(chars));
		
	//	char[] char1 = {'a'};
	//	System.out.println(compress(char1));
		
	//	char[] char2 = {'a','b','b','b','b','b','b','b','b','b','b','b','b'};
	//	System.out.println(compress(char2));
		
	}
	
	public static int compress(char[] chars) {
    	
		int index = 0, write = 0;
		
		while (index < chars.length) {
			
			char curChar = chars[index];
			int count = 0;
			
			while(index < chars.length && chars[index] == curChar) {
				index++;
				count++;
			}
			
			chars[write] = curChar;
			write++;
			
			
		if (count != 1) {
				
				char[] freq = Integer.toString(count).toCharArray();
			for(int j = 0; j < freq.length; j++) {
				//System.out.println(write);
				//System.out.println(j);
				chars[write] = freq[j];
				write++;
			}
			}
			
		}
		
		return write;
		
	}
	
	/*Using StringBuilder
    public static int compress(char[] chars) {
    	
    	char curChar = chars[0];
    	int count = 0;
    	
    	StringBuilder sb = new StringBuilder();
    	
    	for (int i = 0; i < chars.length; i++) {
    		
    		if (chars[i] == curChar) {
    			count++;
    			if (i == chars.length-1) {
    				if (count == 1) {
    				sb.append(curChar);
    				} else {
    				sb.append(curChar).append(count);
    				}
    			}
    			//System.out.println("for loop" + curChar + "   " + chars[i] + "   " + count);
    			
    		} else {
    			//System.out.println("else loop" + curChar + "   " + chars[i] + "   " + count);
    			
    			if (count == 1) {
    				sb.append(curChar);
    				} else {
    				sb.append(curChar).append(count);
    			
    				}
    			
    			count = 1;
    			curChar = chars[i];
    		}
    		
    	}
    	
    	System.out.println(sb);
    	
 
    	return sb.length();
     
    }
    */

	
}
