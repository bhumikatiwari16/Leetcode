package leetcode.Array;

public class RotateMatrix90Deg {

    public static void main(String[] args) {
        int[][] arr = {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        rotate90DegreeClockwise(arr);
        rotate90DegreeAntiClockwise(arr);
    }

    public static void rotate90DegreeClockwise (int arr[][]) {

        int N = arr.length;
        // int col = arr[0].length;

        //For rotation 90 degree clockwise
        //swap the 0th row and Nth row, 1st row and N-1th row and so on till you reach the midpoint of the row.
        //transpose row and columns on swapped array.

        int temp[];
        int i = 0, j = N-1;
        while(i <= j) {
            temp = arr[i];
                arr[i] = arr[j];
                arr[j]= temp;
                i++;
                j--;

            }



        for (i = 0; i <= N/2 ; i++) {
            for (j = i+1; j < N; j++){
                if (!(i == j)){
                    int t = arr[i][j];
                    arr[i][j] = arr[j][i];
                    arr[j][i] = t;
                }
            }
        }

        for (i = 0; i < N; i++) {
            for (j = 0; j < N; j++) {
                System.out.print(arr[i][j] + "  ");
            }
            System.out.println();
        }
    }

    public static void rotate90DegreeAntiClockwise (int arr[][]) {

        int N = arr.length;
        // int col = arr[0].length;

        //For rotation 90 degree clockwise
        //swap the 0th column and Nth column, 1st column and N-1th column and so on till you reach the midpoint of the column.
        //transpose row and columns on swapped array.

        int temp;
        int i; int j;

        for(i = 0; i < N; i++) {
            for(j = 0; j < N/2; j++){
                temp = arr[i][j];
                arr[i][j] = arr[i][N-1-j];
                arr[i][N-1-j] = temp;

            }
        }

        for (i = 0; i < N; i++) {
            for (j = 0; j < N; j++) {
                System.out.print(arr[i][j] + "  ");
            }
            System.out.println();
        }

        for (i = 0; i <= N/2 ; i++) {
            for (j = i+1; j < N; j++){
                if (!(i == j)){
                    int t = arr[i][j];
                    arr[i][j] = arr[j][i];
                    arr[j][i] = t;
                }
            }
        }

        for (i = 0; i < N; i++) {
            for (j = 0; j < N; j++) {
                System.out.print(arr[i][j] + "  ");
            }
            System.out.println();
        }
    }
}
