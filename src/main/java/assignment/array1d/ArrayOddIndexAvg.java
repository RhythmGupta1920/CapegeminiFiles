package assignment.array1d;
import java.util.Scanner;

public class ArrayOddIndexAvg {
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

        float oddIndexAvg = getOddIndexAvg(arr);
        System.out.println("Odd Index Avg: " + oddIndexAvg);
    }

    public static void printArray(int[] array) {
        System.out.print("Array: [");
        for(int i=0; i<array.length; i++) {
            System.out.print(array[i]);
            System.out.print(i<array.length-1 ? ", " : "");
        }
        System.out.println("]");
    }

    public static float getOddIndexAvg(int[] array) {
        float sum = 0.0f;

        for(int i=0; i<array.length; i++) {
            if (!iseven(i+1)) sum += array[i];
        }

        float avg = sum / array.length;
        return avg;
    }

    private static boolean iseven(int n) {
        return (n&1) == 0;
    }
}
