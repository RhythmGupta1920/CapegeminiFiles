package assignment.array1d;
import java.util.Scanner;

public class ArrayOddIndexPrint {
    public static void main(String[] args) {
        int[] arr = new int[5];
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter " + arr.length + " integers:");
        for(int i=0; i<arr.length; i++) {
            int val = sc.nextInt();
            arr[i] = val;
        }
        sc.close();

        printArray(arr);
    }

    public static void printArray(int[] array) {
        System.out.print("Odd Indexed Array Elements: [");
        int end = iseven(array.length) ? array.length-2 : array.length-1;

        for(int i=0; i<=end; i++) {
            if (!iseven(i+1)) {
                System.out.print(array[i]);
                System.out.print(i<end ? ", " : "");
            }
        }
        System.out.println("]");
    }


    private static boolean iseven(int n) {
        return (n&1) == 0;
    }
}
