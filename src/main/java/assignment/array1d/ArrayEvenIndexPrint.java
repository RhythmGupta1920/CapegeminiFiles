package assignment.array1d;
import java.util.Scanner;

public class ArrayEvenIndexPrint {
    public static void main(String[] args) {
        int[] arr = new int[5];
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter 5 integers:");
        for(int i=0; i<arr.length; i++) {
            int val = sc.nextInt();
            arr[i] = val;
        }
        sc.close();

        System.out.println("Even Indexes Elements:");
        printArrayEvenIndexes(arr);
    }

    public static void printArrayEvenIndexes(int[] array) {
        System.out.print("Array: [");
        int end = iseven(array.length) ? array.length-1 : array.length-2;

        for(int i=0; i<array.length; i++) {
            if (!iseven(i+1)) continue;
            System.out.print(array[i]);
            System.out.print(i<end ? ", " : "");
        }
        System.out.println("]");
    }

    private static boolean iseven(int n) {
        return (n&1) == 0;
    }
}
