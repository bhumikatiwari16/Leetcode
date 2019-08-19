package leetcode.Array;

public class MergeSort {

    public static void main(String[] args) {

       // int[] arr = {22, 15, 71, 10, 99};

       // int mid = (0 + arr.length - 1)/2;

      //  int[] arr = {32, 22, 11, 10, 9};

        int[] arr = {6,8,1,5,0};

        int[] result = mergeSort(arr);

        printArray(result);



    }

    public static int[] mergeSort(int[] arr) {

        if (arr.length <= 1) {
            return arr;
        }

        int length = arr.length;
        int mid = (arr.length) / 2;

        int[] arr1 = new int[mid];
        int[] arr2 = new int[length-mid];

     /*
        if (length % 2 == 0) {

            arr2 = new int[length - mid];
        } else {
            arr2 = new int[length - mid + 1];
        }
*/
        int i = 0, j = 0;

        while (i < arr1.length) {
            arr1[i] = arr[i];
            i++;
        }

        while (j < arr2.length) {
            arr2[j] = arr[mid+j];
            j++;
        }

        arr1 = mergeSort(arr1);
        arr2 = mergeSort(arr2);

     //   printArray(arr1);
     //   printArray(arr2);

        int[] res = merge(arr1, arr2);

        return res;
    }

    public static int[] merge (int[] left, int[] right) {

        int[] res = new int[left.length+right.length];
        int leftPtr = 0, rightPtr = 0, resPtr = 0;

        while (leftPtr < left.length || rightPtr < right.length) {
            if (leftPtr < left.length && rightPtr < right.length) {
                if (left[leftPtr] < right[rightPtr]) {
                    res[resPtr] = left[leftPtr];
                    resPtr++;
                    leftPtr++;
                    //  System.out.println(res[resPtr-1]);
                } else {
                    res[resPtr] = right[rightPtr];
                    resPtr++;
                    rightPtr++;
                    //   System.out.println(res[resPtr-1]);
                }
            }

            if (leftPtr < left.length) {
                res[resPtr] = left[leftPtr];
                resPtr++;
                leftPtr++;
              //  System.out.println(res[resPtr-1]);
            }

            if (rightPtr < right.length) {
                res[resPtr] = right[rightPtr];
                resPtr++;
                rightPtr++;
             //   System.out.println(res[resPtr-1]);
            }
        }

        return res;
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "  ");
        }

        System.out.println();
    }


}
