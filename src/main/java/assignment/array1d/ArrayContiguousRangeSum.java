package assignment.array1d;
import java.util.Scanner;

public class ArrayContiguousRangeSum {
    public static void main(String[] args) {
        int[] arr = new int[5];
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter 5 integers:");
        for(int i=0; i<arr.length; i++) {
            int val = sc.nextInt();
            arr[i] = val;
        }
        sc.close();

        printArray(arr);

        int firstHalfSum = getRangeSum(arr, 0, arr.length/2);
        System.out.println("First Half Sum: " + firstHalfSum);

        int secondHalfSum = getRangeSum(arr, arr.length/2, arr.length);
        System.out.println("Second Half Sum: " + secondHalfSum);
    }

    public static void printArray(int[] array) {
        System.out.print("Array: [");
        for(int i=0; i<array.length; i++) {
            System.out.print(array[i]);
            System.out.print(i<array.length-1 ? ", " : "");
        }
        System.out.println("]");
    }

    public static int getRangeSum(int[] array, int start, int end) {
        int sum = 0;

        for(int i=start; i<end; i++)
            sum += array[i];

        return sum;
    }
}
