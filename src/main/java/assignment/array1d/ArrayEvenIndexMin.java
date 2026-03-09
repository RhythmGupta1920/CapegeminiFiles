package assignment.array1d;
import java.util.Scanner;

public class ArrayEvenIndexMin {
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

        int evenIndexMin = getEvenIndexMin(arr);
        System.out.println("Even Index Min: " + evenIndexMin);
    }

    public static void printArray(int[] array) {
        System.out.print("Array: [");
        for(int i=0; i<array.length; i++) {
            System.out.print(array[i]);
            System.out.print(i<array.length-1 ? ", " : "");
        }
        System.out.println("]");
    }

    public static int getEvenIndexMin(int[] array) {
        int min = array.length > 1 ? array[1] : array[0];

        for(int i=1; i<array.length; i++) {
            if (iseven(i+1) && array[i]<min)
                min = array[i];
        }

        return min;
    }

    private static boolean iseven(int n) {
        return (n&1) == 0;
    }
}
