package assignment01.services;


import assignment01.interfaces.Rotate90Right;

public class NxNarray implements Rotate90Right {
    private int [][] _2DArray;

    public NxNarray(int[][] _2DArray) {

        this._2DArray = _2DArray;
    }

    @Override
    public int[][] rotate90degreeRight() {

        // missed exception handling if array is not nXn
        int n = this._2DArray.length - 1;
        int layerCount=(this._2DArray.length-1)/2;
        System.out.println("n in n x n array = " + (n+1));
        System.out.println("layer count = " + (layerCount+1));
        int count=0;
        for (int col=0; col<n;col++){
//            System.out.println(">>> "+col);
            rotate(count, col);
            if (col==n-1 && count<layerCount){
                col=count++; //initialize col before increment count
                n--;

            }
        }
        return this._2DArray;
    }



    public void rotate(int row, int col){
        int n=_2DArray.length-1;
        //1. swap left upper and left lower
//        System.out.println(">>> 1. swap -----");
        this._2DArray[n-col][row]=this._2DArray[row][col]+this._2DArray[n-col][row];
        this._2DArray[row][col]=this._2DArray[n-col][row]-this._2DArray[row][col];
        this._2DArray[n-col][row]=this._2DArray[n-col][row]-this._2DArray[row][col];
//        ArrayWork.display2DIntArr(arr);

        //2. swap left lower and right lower
//        System.out.println(">>> 2. swap -----");
        this._2DArray[n-row][n-col]=this._2DArray[n-row][n-col]+this._2DArray[n-col][row];
        this._2DArray[n-col][row]=this._2DArray[n-row][n-col]-this._2DArray[n-col][row];
        this._2DArray[n-row][n-col]=this._2DArray[n-row][n-col]-this._2DArray[n-col][row];
//        ArrayWork.display2DIntArr(arr);

        //3. swap right lower and right upper
//        System.out.println(">>> 3. swap -----");
        this._2DArray[col][n-row]=this._2DArray[col][n-row]+this._2DArray[n-row][n-col];
        this._2DArray[n-row][n-col]=this._2DArray[col][n-row]-this._2DArray[n-row][n-col];
        this._2DArray[col][n-row]=this._2DArray[col][n-row]-this._2DArray[n-row][n-col];
//        ArrayWork.display2DIntArr(arr);

    }
}
