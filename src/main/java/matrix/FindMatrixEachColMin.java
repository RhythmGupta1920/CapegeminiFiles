package matrix;
import java.util.Scanner;

public class FindMatrixEachColMin {
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

        int[] matrixEachColMin = getMatrixEachColMin(matrix);
        System.out.println("Each Col Min:");
        for(int min: matrixEachColMin)
            System.out.println(min);

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

    public static int[] getMatrixEachColMin(int[][] matrix) {
        if (matrix == null) return null;

        int[] mins = new int[matrix.length];

        for(int i=0; i<matrix.length; i++)
            mins[i] = getMin(matrix[i]);

        return mins;
    }

    public static int getMin(int[] array) {
        if (array == null) return 0;

        int min = array[0];
        for(int item: array) {
            if (item < min) min = item;
        }

        return min;
    }
}
