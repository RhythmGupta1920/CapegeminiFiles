package stack;
import java.util.Arrays;
import java.util.Stack;

public class OnlineStockSpan {
    public static void main(String[] args) {
        int[] prices = {100, 80, 60, 70, 60, 75, 85};
        int[] result = calculateSpan(prices);
        System.out.println(Arrays.toString(prices));
        System.out.println(Arrays.toString(result));
    }

    public static int[] calculateSpan(int[] prices) {
        int n = prices.length;
        int[] span = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() &&
                    prices[st.peek()] <= prices[i])
                st.pop();

            span[i] = st.isEmpty()
                    ? i + 1
                    : i - st.peek();

            st.push(i);
        }

        return span;
    }
}
