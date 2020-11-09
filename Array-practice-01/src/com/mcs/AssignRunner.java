package com.mcs;

public class AssignRunner {
    public static void main(String[] args) {
//        int [][] arr2D=new int[][]{{1,2},{3,4}};
//        int [][] arr2D=new int[][]{{1,2,3},{4,5,6},{7,8,9}};
//        int[][] arr2D = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
//        int [][] arr2D=new int[][]{{1,2,3,4,5},{6,7,8,9,10}, {11,12,13,14,15},{16,17,18,19,20},{21,22,23,24,25}};
        int [][] arr2D=new int[][]{{1,2,3,4,5,6},{7,8,9,10,11,12},{13,14,15,16,17,18},{19,20,21,22,23,24},{25,26,27,28,29,30},{31,32,33,34,35,36}};

        for(int count=0; count<(arr2D.length-1)/2; count++){
            for (int col=count; col<arr2D.length-1-count; col++){
                arr2D=rotate(arr2D, count, col);
            }
        }
        ArrayUtils.display2DIntArr(arr2D);


//        int col = 0;
        //// 2. Rotate an (nxn) matrix 90 degrees right in place
        int n = arr2D.length - 1;
        int loopCount=(arr2D.length-1)/2;
        System.out.println("n = " + n);
        System.out.println("loopCount = " + loopCount);
        int count=0;
        for (int col=0; col<n;col++){
            System.out.println("> count = " + count);
            System.out.println("> col = " + col);
            System.out.println(">>>> swap count: "+count+"\t col count: "+col);
            arr2D=rotate(arr2D, count, col);
            if (col==n-1 && count<loopCount){
                col=count++; //initialize col before increment count
                n--;

            }
        }
        ArrayUtils.display2DIntArr(arr2D);

//        int count=0;
//        int col=0;
//        arr2D=rotate(arr2D, count, col);
//        ArrayWork.display2DIntArr(arr2D);
//        col=1;
//        arr2D=rotate(arr2D, count, col);
//        ArrayWork.display2DIntArr(arr2D);
//        col=2;
//        arr2D=rotate(arr2D, count, col);
//        ArrayWork.display2DIntArr(arr2D);
//        col=3;
//        arr2D=rotate(arr2D, count, col);
//        ArrayWork.display2DIntArr(arr2D);
//        count=1;
//        col=1;
//        arr2D=rotate(arr2D, count, col);
//        ArrayWork.display2DIntArr(arr2D);
//        col=2;
//        arr2D=rotate(arr2D, count, col);
//        ArrayWork.display2DIntArr(arr2D);

//        count=1;
//        for (int col=1; col<n-1;col++){
//            arr2D=rotate(arr2D, count, col);
//        }
//        ArrayWork.display2DIntArr(arr2D);
//        arr2D=rotate(arr2D, row, col);
//        ArrayWork.display2DIntArr(arr2D);
//        System.out.println("-------------------------------");
//        col = 1;
//        arr2D = rotate(arr2D, row, col);
//        ArrayWork.display2DIntArr(arr2D);
//        System.out.println("-------------------------------");
//        col = 2;
//        arr2D = rotate(arr2D, row, col);
//        ArrayWork.display2DIntArr(arr2D);
//        System.out.println("-------------------------------");
//
//        row=1;
//        col = 1;
//        arr2D = rotate(arr2D, row, col);
//        ArrayWork.display2DIntArr(arr2D);
//        System.out.println("-------------------------------");


    }

    public static int[][] rotate(int [][] arr, int row, int col){
        int n=arr.length-1;
        //1. swap left upper and left lower
//        System.out.println(">>> 1. swap -----");
        arr[n-col][row]=arr[row][col]+arr[n-col][row];
        arr[row][col]=arr[n-col][row]-arr[row][col];
        arr[n-col][row]=arr[n-col][row]-arr[row][col];
//        ArrayWork.display2DIntArr(arr);

        //2. swap left lower and right lower
//        System.out.println(">>> 2. swap -----");
        arr[n-row][n-col]=arr[n-row][n-col]+arr[n-col][row];
        arr[n-col][row]=arr[n-row][n-col]-arr[n-col][row];
        arr[n-row][n-col]=arr[n-row][n-col]-arr[n-col][row];
//        ArrayWork.display2DIntArr(arr);

        //3. swap right lower and right upper
//        System.out.println(">>> 3. swap -----");
        arr[col][n-row]=arr[col][n-row]+arr[n-row][n-col];
        arr[n-row][n-col]=arr[col][n-row]-arr[n-row][n-col];
        arr[col][n-row]=arr[col][n-row]-arr[n-row][n-col];
//        ArrayWork.display2DIntArr(arr);

        return arr;
    }
}
