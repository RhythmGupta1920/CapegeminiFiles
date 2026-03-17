package matrix;
import java.util.Scanner;

public class FindMatrixEachRowMax {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[][] matrix;
        int rowSize, colSize;

        System.out.print("Enter size of matrix (row col): ");
        rowSize = sc.nextInt();
        colSize = sc.nextInt();
        matrix = new int[rowSize][colSize];
        inputMatrix(matrix, sc);

        System.out.print("\n");
        print2DArr(matrix);

        int[] matrixEachRowMax = getMatrixEachRowMax(matrix);
        System.out.println("Each Row Max:");
        for(int max: matrixEachRowMax)
            System.out.println(max);

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

    public static int[] getMatrixEachRowMax(int[][] matrix) {
        if (matrix == null) return null;

        int[] maxs = new int[matrix.length];

        for(int i=0; i<matrix.length; i++)
            maxs[i] = getMax(matrix[i]);

        return maxs;
    }

    public static int getMax(int[] array) {
        if (array == null) return 0;

        int max = array[0];
        for(int item: array) {
            if (item > max) max = item;
        }

        return max;
    }
}
