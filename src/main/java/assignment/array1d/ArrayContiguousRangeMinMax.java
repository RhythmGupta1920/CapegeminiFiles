package assignment.array1d;
import java.util.Scanner;

public class ArrayContiguousRangeMinMax {
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

        int firstHalfMin = getRangeMin(arr, 0, arr.length/2);
        System.out.println("First Half Min: " + firstHalfMin);

        int secondHalfMin = getRangeMin(arr, arr.length/2, arr.length);
        System.out.println("Second Half Min: " + secondHalfMin);

        int firstHalfMax = getRangeMax(arr, 0, arr.length/2);
        System.out.println("First Half Max: " + firstHalfMax);

        int secondHalfMax = getRangeMax(arr, arr.length/2, arr.length);
        System.out.println("Second Half Max: " + secondHalfMax);
    }

    public static void printArray(int[] array) {
        System.out.print("Array: [");
        for(int i=0; i<array.length; i++) {
            System.out.print(array[i]);
            System.out.print(i<array.length-1 ? ", " : "");
        }
        System.out.println("]");
    }

    public static int getRangeMin(int[] array, int start, int end) {
        int min = array[start];

        for(int i=start+1; i<end; i++) {
            if (array[i] < min) min = array[i];
        }

        return min;
    }

    public static int getRangeMax(int[] array, int start, int end) {
        int max = array[start];

        for(int i=start+1; i<end; i++) {
            if (array[i] > max) max = array[i];
        }

        return max;
    }
}
