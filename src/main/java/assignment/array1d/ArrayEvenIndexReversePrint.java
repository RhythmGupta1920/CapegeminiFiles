package assignment.array1d;
import java.util.Scanner;



public class ArrayEvenIndexReversePrint {
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
        rprintArrayEvenIndexes(arr);
    }

    public static void rprintArrayEvenIndexes(int[] array) {
        System.out.print("Array: [");
        int start = iseven(array.length) ? 0 : 1;
        int end = array.length-1;

        for(int i=end; i>=0; i--) {
            if (!iseven(end-i+1)) continue;
            System.out.print(array[i]);
            System.out.print(i>start ? ", " : "");
        }
        System.out.println("]");
    }

    private static boolean iseven(int n) {
        return (n&1) == 0;
    }
}
