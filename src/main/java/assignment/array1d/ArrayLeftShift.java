package assignment.array1d;
import java.util.Scanner;

public class ArrayLeftShift {
    public static void main(String[] args) {
        int[] arr = new int[5];
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter " + arr.length + " integers:");
        for(int i=0; i<arr.length; i++) {
            int val = sc.nextInt();
            arr[i] = val;
        }

        printArray(arr);

        for(int i=1; i<=3; i++) {
            System.out.println("");
            int[] arrcpy = new int[arr.length];
            for(int j=0; j<arr.length; j++) arrcpy[j] = arr[j];

            leftShiftArrayBy(arr, 1);
            System.out.println("Array after left shifting elements by " + i + ":");
            printArray(arr);
        }

        sc.close();
    }

    public static void printArray(int[] array) {
        System.out.print("Array: [");

        for(int i=0; i<array.length; i++) {
            System.out.print(array[i]);
            System.out.print(i<array.length-1 ? ", " : "");
        }
        System.out.println("]");
    }

    public static void leftShiftArrayBy(int[] array, int bits) {
        for(int i=0; i<array.length; i++)
            array[i] = array[i]<<bits;
    }
}
