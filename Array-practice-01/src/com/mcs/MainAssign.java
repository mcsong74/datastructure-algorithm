package com.mcs;


import com.mcs.interfaces.Rotate90Right;
import com.mcs.services.NxNarray;

public class MainAssign {
    public static void main(String[] args) {
//        int [][] arr2D=new int[][]{{1,2},{3,4}};
//        int [][] arr2D=new int[][]{{1,2,3},{4,5,6},{7,8,9}};
//        int[][] arr2D = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
//        int [][] arr2D=new int[][]{{1,2,3,4,5},{6,7,8,9,10}, {11,12,13,14,15},{16,17,18,19,20},{21,22,23,24,25}};
//        int [][] arr2D=new int[][]{{1,2,3,4,5,6},{7,8,9,10,11,12},{13,14,15,16,17,18},{19,20,21,22,23,24},{25,26,27,28,29,30},{31,32,33,34,35,36}};
        int[][] arr2D=ArrayUtils.createNxNarray(4);
        Rotate90Right rotate=new NxNarray(arr2D);
        ArrayUtils.display2DIntArr(rotate.rotate90degreeRight());


        arr2D=ArrayUtils.createNxNarray(10);
        Rotate90Right rotate1 =new NxNarray(arr2D);
        ArrayUtils.display2DIntArr(rotate1.rotate90degreeRight());




    }
}
