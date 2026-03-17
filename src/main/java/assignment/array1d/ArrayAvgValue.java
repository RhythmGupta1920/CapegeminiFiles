package assignment.array1d;
import java.util.Scanner;

public class ArrayAvgValue {
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

        float arrayAvgVal = getArrayAvgValue(arr);
        System.out.println("Max: " + arrayAvgVal);
    }

    public static void printArray(int[] array) {
        System.out.print("Array: [");
        for(int i=0; i<array.length; i++) {
            System.out.print(array[i]);
            System.out.print(i<array.length-1 ? ", " : "");
        }
        System.out.println("]");
    }

    public static int getArraySum(int[] array) {
        int sum = 0;
        for(int item: array) sum += item;
        return sum;
    }

    public static float getArrayAvgValue(int[] array) {
        float arraySum = getArraySum(array);
        return arraySum/array.length;
    }
}
