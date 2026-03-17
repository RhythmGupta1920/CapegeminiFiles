package matrix;
import java.util.Scanner;

public class MatrixCountOddEven {
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

        int[] evenOddCount = getEvenOddCount(matrix);
        System.out.println("Even elements count: " + evenOddCount[0]);
        System.out.println("Odd elements count: " + evenOddCount[1]);

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

    public static int[] getEvenOddCount(int[][] matrix) {
        int[] evenOddCount = new int[2];

        for(int i=0; i<matrix.length; i++) {
            for(int j=0; j<matrix[0].length; j++) {
                if (iseven(matrix[i][j]))
                    evenOddCount[0]++;
                else evenOddCount[1]++;
            }
        }

        return evenOddCount;
    }

    public static boolean iseven(long n) {
        return (n&1) == 0;
    }
}
