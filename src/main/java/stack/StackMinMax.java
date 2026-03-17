package stack;
import java.util.Stack;

class MyStack {
    public class Node {
        int val, min, max;

        Node(int val, int min, int max) {
            this.val = val;
            this.min = min;
            this.max = max;
        }
    }

    private Stack<Node> stack = new Stack<>();

    public void push(int val) {
        if (stack.isEmpty()) {
            stack.push(new Node(val, val, val));
        } else {
            int currMin = Math.min(val, stack.peek().min);
            int currMax = Math.max(val, stack.peek().max);

            stack.push(new Node(val, currMin, currMax));
        }
    }

    public Node pop() {
        return stack.pop();
    }

    public int getMin() {
        return stack.peek().min;
    }

    public int getMax() {
        return stack.peek().max;
    }
}

public class StackMinMax {
    public static void main(String[] args) {
        MyStack stack = new MyStack();

        stack.push(10);
        stack.push(2);
        stack.push(15);

        System.out.println("Min: " + stack.getMin());
        System.out.println("Max: " + stack.getMax());
    }
}
