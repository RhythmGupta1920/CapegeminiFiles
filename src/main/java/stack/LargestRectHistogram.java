package stack;
import java.util.Stack;

public class LargestRectHistogram {
    public static void main(String[] args) {
        int[] arr = {6, 2, 5, 4, 5, 1, 6};
        System.out.println(largestRect(arr));
    }


    public static int largestRect(int[] h) {
        Stack<Integer> s = new Stack<>();
        int max = 0;
        int i = 0;

        while (i < h.length) {
            if (s.isEmpty() ||
                    h[i] >= h[s.peek()]) {
                s.push(i);
                i++;
            } else {
                int top = s.pop();

                int width;
                width = (s.isEmpty())
                        ? i
                        : i - s.peek() - 1;

                int area = h[top] * width;
                if (area > max) max = area;
            }
        }

        while (!s.isEmpty()) {
            int top = s.pop();

            int width;
            width = (s.isEmpty())
                    ? i
                    : i - s.peek() - 1;

            int area = h[top] * width;
            if (area > max) max = area;
        }

        return max;
    }
}
