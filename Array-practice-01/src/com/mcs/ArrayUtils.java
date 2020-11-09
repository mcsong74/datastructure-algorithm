package com.mcs;

public class ArrayUtils {
    //1. Reverse order of an array of unordered integer
    public static int [] reverseIntArray(int[] myArray){
        int [] tempArr=new int[myArray.length];
        for (int i=myArray.length-1; i>=0; i--){
            tempArr[(tempArr.length-1)-i]=myArray[i];
        }
        return tempArr;
    }
    // 2. Rotate an (nxn) matrix 90 degrees right in place with additional new array
    public static int[][] rotateRight90DegreeOneLoop(int[][] nXnArr){
        // one for loop used,
        int sizeN=nXnArr.length;
        int [][] tempArr=new int[sizeN][sizeN];
        int row=sizeN-1;
        for (int col=0; col<sizeN; col++){
            tempArr[col][(sizeN-1)-row]=nXnArr[row][col];
            if(row==0){
                row=sizeN-1;
            }else{
                col-=1;
                row--;
            }
        }
        return tempArr;
    }
    public static int[][] rotate90DegreeRightNestLoop(int[][] nXnArr){//with additional new array
        //nested for loop used
        int [][] tempArr=new int[nXnArr.length][nXnArr[0].length];
        int sizeN;
        sizeN = nXnArr.length;
        for (int col=0; col<sizeN; col++){
            for (int row = sizeN-1; row>=0; row--){
                tempArr[col][(sizeN-1)-row]=nXnArr[row][col];
            }
        }
        return tempArr;
    }

    public static void display2DIntArr(int[][] myArr){

        System.out.println(">>> print array ------");
        for(int[] arr:myArr){
            System.out.print("\t");
            for(int number:arr){
                System.out.print(number+"\t");
            }
            System.out.println("");
        }
    }
    public static int[][] createNxNarray(int n){
        int[][] tempArr=new int[n][n];
        System.out.println(tempArr.length);
        int number=1;
        for(int row=0; row<tempArr.length; row++){
            for(int col=0; col<tempArr[row].length;col++){
                tempArr[row][col]=number;
                number++;
            }
        }
        return tempArr;
    }


}
