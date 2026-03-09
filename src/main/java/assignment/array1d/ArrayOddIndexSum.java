package assignment.array1d;
import java.util.Scanner;

public class ArrayOddIndexSum {
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

        int arrayOddIndexSum = getArrayOddIndexSum(arr);
        System.out.println("Odd Index Sum: " + arrayOddIndexSum);
    }

    public static void printArray(int[] array) {
        System.out.print("Array: [");
        for(int i=0; i<array.length; i++) {
            System.out.print(array[i]);
            System.out.print(i<array.length-1 ? ", " : "");
        }
        System.out.println("]");
    }

    public static int getArrayOddIndexSum(int[] array) {
        int sum = 0;

        for(int i=0; i<array.length; i++) {
            if (!iseven(i+1)) sum += array[i];
        }

        return sum;
    }

    private static boolean iseven(int n) {
        return (n&1) == 0;
    }
}
