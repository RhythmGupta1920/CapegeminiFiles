package matrix;
import java.util.Scanner;

public class MatrixAddition {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[][] matrix1, matrix2;
        int rowSize, colSize;

        System.out.print("Enter size of matrix-1 (row col): ");
        rowSize = sc.nextInt();
        colSize = sc.nextInt();
        matrix1 = new int[rowSize][colSize];
        inputMatrix(matrix1, sc);

        System.out.print("Enter size of matrix-2 (row col): ");
        rowSize = sc.nextInt();
        colSize = sc.nextInt();
        matrix2 = new int[rowSize][colSize];
        inputMatrix(matrix2, sc);

        System.out.print("\n1. ");
        print2DArr(matrix1);

        System.out.print("\n2. ");
        print2DArr(matrix2);

        int[][] resultMatrix = addMatrix(matrix1, matrix2);

        System.out.println("\nResultant matrix after addition:");
        print2DArr(resultMatrix);

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

    public static int[][] addMatrix(int[][] mat1, int[][] mat2) {
        if (mat1 == null || mat2 == null)
            return null;

        int mat1RowSize = mat1.length;
        int mat1ColSize = mat1[0].length;
        int mat2RowSize = mat2.length;
        int mat2ColSize = mat2[0].length;

        if (mat1RowSize != mat2RowSize || mat1ColSize != mat2ColSize)
            return null;

        int[][] result = new int[mat1RowSize][mat1ColSize];
        for(int row = 0; row<mat1RowSize; row++) {
            for(int col=0; col<mat1ColSize; col++)
                result[row][col] = mat1[row][col] + mat2[row][col];
        }

        return result;
    }
}
