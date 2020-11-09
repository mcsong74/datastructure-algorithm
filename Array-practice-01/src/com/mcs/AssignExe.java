package com.mcs;

import java.util.Arrays;

public class AssignExe {
    public static void main(String[] args) {
        //assignment 1, Wed, 10/21/2020
        //// 1. Reverse order of an array of unordered integer
        System.out.println("-------------1. Reverse order of an array of unordered integer----------------");
        int [] myArray=new int[]{1,2,3,2,7,6,5,8,9,10};
        myArray= ArrayUtils.reverseIntArray(myArray);
        System.out.println(Arrays.toString(myArray));
        int tempInt;
        for(int indexCount=0; indexCount<myArray.length; indexCount++){
            for(int index=0; index<myArray.length-1; index++){
                tempInt=myArray[index+1];
                myArray[index+1]=myArray[index];
                myArray[index]=tempInt;
            }
        }
        System.out.println(Arrays.toString(myArray));

        //// 1. Reverse order of an array of unordered integer, no temp variable used
        for(int indexCount=0; indexCount<myArray.length; indexCount++){
            for (int index=0; index<myArray.length-1; index++){
                myArray[index+1]=myArray[index]+myArray[index+1];
                myArray[index]=myArray[index+1]-myArray[index];
                myArray[index+1]=myArray[index+1]-myArray[index];
            }
        }

        System.out.println(Arrays.toString(myArray));

        //// 2. Rotate an (nxn) matrix 90 degrees right in place
        System.out.println("-------------2. Rotate an (nxn) matrix 90 degrees right in place----------------");

//        int [][] arr2D=new int[][]{{1,2},{3,4}};
//        int [][] arr2D=new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        int [][] arr2D=new int[][]{{1,2,3,4},{5,6,7,8}, {9,10,11,12},{13,14,15,16}};
//        int [][] arr2D=new int[][]{{1,2,3,4,5},{6,7,8,9,10}, {11,12,13,14,15},{16,17,18,19,20},{21,22,23,24,25}};
//        int [][] arr2D=new int[][]{{1,2,3,4,5,6},{7,8,9,10,11,12},{13,14,15,16,17,18},{19,20,21,22,23,24},{25,26,27,28,29,30},{31,32,33,34,35,36}};
        ArrayUtils.display2DIntArr(arr2D);
        System.out.println("-------------Rotate 90 degree right below ----------------");
        ArrayUtils.display2DIntArr( ArrayUtils.rotateRight90DegreeOneLoop(arr2D));
        System.out.println("-------------Rotate 90 degree right below swap----------------");
        int tempNum, rowMax, colMax;
        rowMax=arr2D.length-1;
        colMax=arr2D[0].length-1;

        System.out.println("Total row count= "+rowMax+"\t total column = "+colMax);
        int arrSizeN;
        arrSizeN = arr2D.length-1;
        tempNum=arr2D[0][0]; //1
        //left
//        int col=0;
        for (int row=0; row<arr2D.length/2;row++){
            for (int col=row; col<arrSizeN-1; col++){
                tempNum=arr2D[row][col];
                arr2D[row][col]=arr2D[arrSizeN-col][row];
                arr2D[arrSizeN-col][row]=arr2D[arrSizeN-row][arrSizeN-col];
                arr2D[arrSizeN-row][arrSizeN-col]=arr2D[col][arrSizeN-row];
                arr2D[col][arrSizeN-row]=tempNum;
                ArrayUtils.display2DIntArr(arr2D);System.out.println("");
            }

        }

        System.out.println("-------------Rotate 90 degree right below swap no temp----------------");
//        int row=0;
//        int col=0;
//        arr2D=new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        arr2D=new int[][]{{1,2,3,4},{5,6,7,8}, {9,10,11,12},{13,14,15,16}};

        arrSizeN=arr2D.length-1;
        for(int row=0; row<arr2D.length/2;row++){
            for (int col=row; col<arrSizeN; col++){
                System.out.println("col = " + col);
                //left upper corner vs left lower corner
                arr2D[arrSizeN-col][row]=arr2D[arrSizeN-col][row]+arr2D[row][col];
                arr2D[row][col]=arr2D[arrSizeN-col][row]-arr2D[row][col];
                arr2D[arrSizeN-col][row]=arr2D[arrSizeN-col][row]-arr2D[row][col];
                ArrayUtils.display2DIntArr(arr2D);System.out.println("");

                //left lower corner vs right lower corner
                arr2D[arrSizeN-row][arrSizeN-col]=arr2D[arrSizeN-col][row]+arr2D[arrSizeN-row][arrSizeN-col];
                arr2D[arrSizeN-col][row]=arr2D[arrSizeN-row][arrSizeN-col]-arr2D[arrSizeN-col][row];
                arr2D[arrSizeN-row][arrSizeN-col]=arr2D[arrSizeN-row][arrSizeN-col]-arr2D[arrSizeN-col][row];
                ArrayUtils.display2DIntArr(arr2D);System.out.println("");

                //right lower corner vs right upper corner
                arr2D[col][arrSizeN]=arr2D[arrSizeN-row][arrSizeN-col]+arr2D[col][arrSizeN];
                arr2D[arrSizeN-row][arrSizeN-col]=arr2D[col][arrSizeN]-arr2D[arrSizeN-row][arrSizeN-col];
                arr2D[col][arrSizeN]=arr2D[col][arrSizeN]-arr2D[arrSizeN-row][arrSizeN-col];
                ArrayUtils.display2DIntArr(arr2D);System.out.println("");

            }
        }


//        //left upper corner vs left lower corner
//        arr2D[arrSizeN-col][row]=arr2D[arrSizeN-col][row]+arr2D[row][col];
//        arr2D[row][col]=arr2D[arrSizeN-col][row]-arr2D[row][col];
//        arr2D[arrSizeN-col][row]=arr2D[arrSizeN-col][row]-arr2D[row][col];
//        //left lower corner vs right lower corner
//        arr2D[arrSizeN][arrSizeN-col]=arr2D[arrSizeN-col][row]+arr2D[arrSizeN][arrSizeN-col];
//        arr2D[arrSizeN-col][row]=arr2D[arrSizeN][arrSizeN-col]-arr2D[arrSizeN-col][row];
//        arr2D[arrSizeN][arrSizeN-col]=arr2D[arrSizeN][arrSizeN-col]-arr2D[arrSizeN-col][row];
////        //right lower corner vs right upper corner
//        arr2D[row+col][arrSizeN]=arr2D[arrSizeN][arrSizeN-col]+arr2D[row+col][arrSizeN];
//        arr2D[arrSizeN][arrSizeN-col]=arr2D[row+col][arrSizeN]-arr2D[arrSizeN][arrSizeN-col];
//        arr2D[row+col][arrSizeN]=arr2D[row+col][arrSizeN]-arr2D[arrSizeN][arrSizeN-col];

        //rotate other num not corner








        System.out.println("-----------");
        ArrayUtils.display2DIntArr(arr2D);

        //3 x 3
//        int n=arr2D.length;
//        int row=n-1;
//        for (int col=0; col<n; col++){
//            tempArr[col][(n-1)-row]=arr2D[row][col];
//            if(row==0){
//                row=n-1;
//            }else{
//                col-=1;
//                row--;
//            }
//        }


    }

}
