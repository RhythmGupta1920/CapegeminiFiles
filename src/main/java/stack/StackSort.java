package stack;

import java.util.Stack;
public class StackSort {
    public static void sortStack(Stack<Integer> stack) {
        if (!stack.isEmpty()) {
            int temp = stack.pop();
            sortStack(stack);
            sortedInsert(stack, temp);
        }
    }

    public static void sortedInsert(Stack<Integer> stack, int element) {
        if (stack.isEmpty() || element > stack.peek()) {
            stack.push(element);
        } else {
            int temp = stack.pop();
            sortedInsert(stack, element);
            stack.push(temp);
        }
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        stack.push(30);
        stack.push(-5);
        stack.push(18);
        stack.push(14);
        stack.push(-3);

        System.out.println(stack);
        sortStack(stack);
        System.out.println(stack);
    }
}
