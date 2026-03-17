package stack;
import java.util.Stack;

public class Celebrity {
    public static int findCelebrity(int[][] M, int n) {
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++)
            st.push(i);

        while (st.size() > 1) {
            int a = st.pop();
            int b = st.pop();
            st.push(M[a][b] == 1 ? b : a);
        }

        int candidate = st.pop();

        for (int i = 0; i < n; i++) {
            if (i != candidate &&
                    (M[candidate][i] == 1 ||
                            M[i][candidate] == 0))
                return -1;
        }

        return candidate;
    }

    public static void main(String[] args) {
        int[][] M = {
                {0, 1, 0},
                {0, 0, 0},
                {0, 1, 0}
        };

        int n = 3;
        int result = findCelebrity(M, n);

        if (result == -1) {
            System.out.println("No Celebrity found");
        } else {
            System.out.println(result);
        }
    }
}
