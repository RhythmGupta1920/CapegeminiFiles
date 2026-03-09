package matrix;
import java.util.Scanner;

public class MatrixReversePrint {public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int[][] matrix;

    System.out.print("Enter size of matrix (row col): ");
    int rowSize = sc.nextInt();
    int colSize = sc.nextInt();
    matrix = new int[rowSize][colSize];

    inputMatrix(matrix, sc);

    System.out.println("");
    print2DArr(matrix);
    System.out.println("");

    print2DArrReverse(matrix);

    sc.close();
}

    public static void inputMatrix(int[][] matrix, Scanner sc) {
        System.out.println("Enter matrix elements:");
        int rowSize = matrix.length;
        int colSize = matrix[0].length;

        for(int row = 0; row<rowSize; row++) {
            for(int col = 0; col<colSize; col++)
                matrix[row][col] = sc.nextInt();
        }
    }

    public static void print2DArr(int[][] matrix) {
        if (matrix == null) {
            System.out.println("Matrix: []");
            return;
        }

        int rowSize = matrix.length;
        int colSize = matrix[0].length;

        System.out.println("Matrix:");
        for(int row = 0; row < rowSize; row++) {
            System.out.print("[");
            for(int col = 0; col < colSize; col++) {
                System.out.print(matrix[row][col]);
                System.out.print(col < colSize-1 ? " " : "");
            }
            System.out.println("]");
        }
    }

    public static void print2DArrReverse(int[][] matrix) {
        if (matrix == null) {
            System.out.println("Matrix: []");
            return;
        }

        int rowSize = matrix.length;
        int colSize = matrix[0].length;

        System.out.println("Reverse Matrix:");
        for(int row = rowSize-1; row >= 0; row--) {
            System.out.print("[");
            for(int col = colSize-1; col >= 0; col--) {
                System.out.print(matrix[row][col]);
                System.out.print(col > 0 ? " " : "");
            }
            System.out.println("]");
        }
    }
}
