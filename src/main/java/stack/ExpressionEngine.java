package stack;
import java.util.Scanner;
import java.util.Stack;


public class ExpressionEngine {public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    Stack<Integer> stack = new Stack<>();

    System.out.print("postfix expression  ");
    String expression = sc.nextLine();
    String[] tokens = expression.split(" ");

    for (String token : tokens) {
        if (Character.isDigit(token.charAt(0))) {
            stack.push(Integer.parseInt(token));
        } else {
            int b = stack.pop();
            int a = stack.pop();

            switch (token) {
                case "+":
                    stack.push(a + b);
                    break;
                case "-":
                    stack.push(a - b);
                    break;
                case "*":
                    stack.push(a * b);
                    break;
                case "/":
                    stack.push(a / b);
                    break;
            }
        }
    }

    System.out.println(stack.pop());
    sc.close();
}

}
