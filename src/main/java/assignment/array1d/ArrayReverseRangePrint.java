package assignment.array1d;
import java.util.Scanner;

public class ArrayReverseRangePrint {public static void main(String[] args) {
    int[] arr = new int[5];
    Scanner sc = new Scanner(System.in);

    System.out.println("Enter 5 integers:");
    for(int i=0; i<arr.length; i++) {
        int val = sc.nextInt();
        arr[i] = val;
    }
    sc.close();

    System.out.println("First Half in Reverse:");
    rprintArrayFrom(arr, 0, arr.length/2);

    System.out.println("\nSecond Half in Reverse:");
    rprintArrayFrom(arr, arr.length/2, arr.length);
}

    public static void rprintArrayFrom(int[] array, int start, int end) {
        System.out.print("Reverse Array: [");
        for(int i=end-1; i>=start; i--) {
            System.out.print(array[i]);
            System.out.print(i>start ? ", " : "");
        }
        System.out.println("]");
    }
}
