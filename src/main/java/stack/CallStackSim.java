package stack;
import java.util.Stack;

public class CallStackSim {
    private static Stack<String> callStack = new Stack<>();

    public static void main(String[] args) {
        enterMethod("main");
        enterMethod("login()");
        enterMethod("validate()");

        exitMethod();
        exitMethod();
        exitMethod();
    }

    private static void enterMethod(String methodName) {
        callStack.push(methodName);
        System.out.println("CALL: " + methodName +
                " | Current Stack: " + callStack);
    }

    private static void exitMethod() {
        String removed = callStack.pop();
        System.out.println("RETURN: " + removed +
                " | Current Stack: " + callStack);
    }
}
