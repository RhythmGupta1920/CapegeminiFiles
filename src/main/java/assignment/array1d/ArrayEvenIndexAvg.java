package assignment.array1d;
import java.util.Scanner;

public class ArrayEvenIndexAvg {
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

        float evenIndexAvg = getEvenIndexAvg(arr);
        System.out.println("Even Index Avg: " + evenIndexAvg);
    }

    public static void printArray(int[] array) {
        System.out.print("Array: [");
        for(int i=0; i<array.length; i++) {
            System.out.print(array[i]);
            System.out.print(i<array.length-1 ? ", " : "");
        }
        System.out.println("]");
    }

    public static float getEvenIndexAvg(int[] array) {
        float sum = 0.0f;

        for(int i=0; i<array.length; i++) {
            if (iseven(i+1)) sum += array[i];
        }

        float avg = sum / array.length;
        return avg;
    }

    private static boolean iseven(int n) {
        return (n&1) == 0;
    }
}
