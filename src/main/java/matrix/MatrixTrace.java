package matrix;
import java.util.Scanner;

public class MatrixTrace {
    public static void main(String[] args) {
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

        int trace = getMatrixTrace(matrix);
        System.out.println("Trace: " + trace);

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

    public static int getMatrixTrace(int[][] matrix) {
        if (matrix == null) return 0;

        int rows = matrix.length;
        int cols = matrix[0].length;

        if (rows != cols) return 0;

        int trace = 0;
        for(int i=0; i<rows; i++)
            trace += matrix[i][i];

        return trace;
    }
}
