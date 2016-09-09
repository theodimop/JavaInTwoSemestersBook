package P161_Ex10b;

import java.util.Random;

/**
 * -------------------------------------
 * Created by Theo Dimopoulos on 9/8/16.|
 * Email: dimopoulosth.td@gmail.com" )  |
 * -------------------------------------
 * * Ex. Write a fragment of code that finds the largest number in a triangle-ragged array
 * Solution. Create and triangle array, fill it with pseudo-random values, and search for the max value
 */
public
class Main {


    private static final int ROWS = 6;//The rows of the triangle array

    public static void main(String args[]) {

        int[][] triangleArray = initTriangleArray();

        fillArray(triangleArray);
        printTriangleArray(triangleArray);
        printMax(triangleArray);

    }

    //Initialize a triangle array
    private static int[][] initTriangleArray() {
        int[][] array = new int[ROWS][];

        for (int i = 0; i < ROWS; i++)
            array[i] = new int[i + 1];

        return array;
    }

    //Adding random values to the array. All values are inside [0,100]
    private static void fillArray(int[][] array) {

        Random randomInt = new Random();

        for (int i = 0; i < ROWS; i++)
            for (int j = 0; j <= i; j++) {
                array[i][j] = randomInt.nextInt(100);
            }
    }

    //Print triangle array.
    private static void printTriangleArray(int[][] array) {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print("[" + array[i][j] + "] ");
            }
            System.out.print("\n");
        }
    }

    //Return the max element of a triangle array
    /*Implementation Comments: the max is the element at 0 0. The algorithm starts comparing at
    * the second row*/
    private static void printMax(int[][] array) {

        int max = array[0][0], row = 0, col = 0;

        for (int i = 1; i < ROWS; i++)
            for (int j = 0; j <= i; j++)
                if (array[i][j] > max) {
                    max = array[i][j];
                    row = i+1;
                    col = j+1;
                }
        System.out.print("Max value :" + max + " at row:" + row + " col:" + col);
    }
}
