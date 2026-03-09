import java.util.Scanner;

class MatrixIndex {
    public int row;
    public int col;
    public int rows;
    public int cols;

    MatrixIndex(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.row = -1;
        this.col = -1;
    }

    public void setIndex(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public boolean isnpos() {
        return row < 0 || col < 0 ||
                row >= rows || col >= cols;
    }

    public int getValue(int[][] matrix) {
        return matrix[row][col];
    }
}

public class FindMatrixElement {
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

        System.out.print("Enter the element to find its index: ");
        int ele = sc.nextInt();

        MatrixIndex matIdx = find(ele, matrix);
        if (!matIdx.isnpos()) {
            System.out.println("Row Index: " + matIdx.row);
            System.out.println("Col Index: " + matIdx.col);
        } else System.out.println("Index: None");

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

    public static MatrixIndex find(int val, int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        MatrixIndex idx = new MatrixIndex(rows, cols);

        for(int i=0; i<rows; i++) {
            for(int j=0; j<cols; j++) {
                if (val == matrix[i][j]) {
                    idx.setIndex(i, j);
                    return idx;
                }
            }
        }

        return idx;
    }
}
