package leetcode.Array;

public class RottenOranges {

	public static void main(String[] args) {

		/*
		int[][] grid1 = {{2,1,1},{1,1,0},{0,1,1}};

		System.out.println(orangesRotting(grid1));

		int[][] grid2 = {{2,1,1},{0,1,1},{1,0,1}};
		System.out.println(orangesRotting(grid2));
		
		int[][] grid3 = {{0,2}};
		System.out.println(orangesRotting(grid3));
		*/
		
		int[][] grid3 = {{1,2}};
		System.out.println(orangesRotting(grid3));
		
		
	}

	public static int orangesRotting(int[][] grid) {

		int row = grid.length;
		int col = grid[0].length;
		int mins = 0;
		boolean flag = false;

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {

				if (grid[i][j] == 2) {

					if (((i-1) >= 0) && (grid[i-1][j] == 1)) {
						grid[i-1][j] = 2;
						//System.out.println("first"+ (i-1)+ " " + j);
						flag = true;
					}

					if (((i+1) < row) && (grid[i+1][j] == 1)) {
						grid[i+1][j] = 2;
						//System.out.println("sec"+ (i+1)+ " " + j);
						flag = true;
					}

					if (((j-1) >= 0) && (grid[i][j-1] == 1)) {
						grid[i][j-1] = 2;
						//System.out.println("third"+ i + " " + (j-1));
						flag = true;
					}

					if (((j+1) < col) && (grid[i][j+1] == 1)) {
						grid[i][j+1] = 2;
						//System.out.println("four"+ i+ " " + (j+1));
						flag = true;
					}

					if (flag == true) {
						mins++;
						flag = false;	
					}
					
					//System.out.println("mins:"+ mins);

				}

			}	

		}

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {

				//System.out.println(grid[i][j]);
				if (grid[i][j] == 1) {
					return -1;
				}
			}
		}

		return mins;

	}

}
