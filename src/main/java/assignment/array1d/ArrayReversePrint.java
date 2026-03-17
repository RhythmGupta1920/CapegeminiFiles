package assignment.array1d;
import java.util.Scanner;

public class ArrayReversePrint {
    public static void main(String[] args) {
        int[] arr = new int[5];
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter 5 integers:");
        for(int i=0; i<arr.length; i++) {
            int val = sc.nextInt();
            arr[i] = val;
        }
        sc.close();

        rprintArray(arr);
    }

    public static void rprintArray(int[] array) {
        System.out.print("Reverse Array: [");
        for(int i=array.length-1; i>=0; i--) {
            System.out.print(array[i]);
            System.out.print(i>0 ? ", " : "");
        }
        System.out.println("]");
    }
}
