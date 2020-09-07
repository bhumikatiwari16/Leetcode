package leetcode.Array;

public class wordCountIn2DArray {

	public static void main(String[] args) {
		
		char[][] board = new char[][] {{'A','B','C','E'},
				{'S','F','C','S'},
				{'F','C','S','E'}};
				
		String word = "FCS";
		
		System.out.println(wordCount(board, word));
		
		

	}
	
	static int wordCount (char[][] board, String word) {
		
		int r = board.length;
		int c = board[0].length;
		
		int result = 0;
		
		for (int i = 0; i < r; i++) {
			for(int j = 0; j < c; j++) {
				
				if (board[i][j] == word.charAt(0) && dfs(board, i, j, 0, word)) {
					result++;
				}
			}
		}
		
		return result;
	}
	
	static boolean dfs(char[][] board, int i, int j, int count, String word) {
		
		if (count == word.length()) {
			return true;
		}

		if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(count)) {
			return false;
		}
		
		char temp = board[i][j];
		board[i][j] = ' ';
		boolean found  = dfs(board, i+1, j, count+1, word)||
					dfs(board, i, j+1, count+1,word) ||
					dfs(board, i-1, j, count+1, word)||
					dfs(board, i, j-1, count+1, word) ||
					dfs(board, i-1, j-1, count+1, word) ||
					dfs(board, i-1, j+1,count+1, word)||
					dfs(board, i+1,j+1,count+1, word)||
					dfs(board, i+1, j-1, count+1, word);
		
		board[i][j]=temp;
		
		if(found) {
			return true;
		} 
		
		return false;
	}

}
