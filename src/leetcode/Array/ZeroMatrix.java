package leetcode.Array;

public class ZeroMatrix {

    public static void main(String[] args) {

        int[][] arr = {
                {0,2,3,4},
                {4,5,7,9},
                {7,0,9,3}
        };
        zeroMat(arr);
    }

    public static void zeroMat(int[][] arr) {

        int row = arr.length;
        int col = arr[0].length;
        boolean firRow = false, firCol =  true;
// we will check if first row contains 0 if yes we will make firRow as true same for col

// and also we will make first row and first column of all element which are 0 as 0
         for (int i = 0; i < row; i++) {
             for (int j = 0; j < col; j++) {

                 if (arr[i][j] == 0) {
                     if(j==0)
                     firCol = true;
                     if(i==0)
                         firRow=true;

                     arr[0][j]=0;
                     arr[i][0]=0;
                 }
             }
         }
// we will check for all rows and col > 1
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {

                if (arr[i][0] == 0 || arr[0][j]==0 ) {
                   arr[i][j]=0;
                }
            }
        }

    if(firRow){
        for(int i =0;i<col;i++){
            arr[0][i]=0;

        }
    }
        if(firCol){
            for(int i =0;i<row;i++){
                arr[i][0]=0;

            }
        }

        for (int p = 0; p < row; p++) {
            for (int q = 0; q < col; q++) {
                System.out.print(arr[p][q] + "  ");
            }
            System.out.println();
        }
    }
}
