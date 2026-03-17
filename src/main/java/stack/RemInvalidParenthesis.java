package stack;
import java.util.Stack;

public class RemInvalidParenthesis {
    public static void main(String[] args) {
        String s = "a)b(c)d";
        System.out.println("Input:  " + s);
        System.out.println("Output: " + removeInvalid(s));

        String s2 = "((a)b";
        System.out.println("Input:  " + s2);
        System.out.println("Output: " + removeInvalid(s2));
    }

    public static String removeInvalid(String s) {
        Stack<Integer> st = new Stack<>();
        boolean[] bad = new boolean[s.length()];

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(') {
                st.push(i);
            } else if (c == ')') {
                if (!st.isEmpty()) st.pop();
                else bad[i] = true;
            }
        }


        while (!st.isEmpty())
            bad[st.pop()] = true;

        String res = "";
        for (int i = 0; i < s.length(); i++) {
            if (!bad[i])
                res += s.charAt(i);
        }

        return res;
    }
}
