package stack;

import java.util.LinkedList;
import java.util.Queue;

public class TwoQueueStack {Queue<Integer> q1 = new LinkedList<>();
    Queue<Integer> q2 = new LinkedList<>();

    public void pushMethod1(int x) {
        q2.add(x);
        while (!q1.isEmpty())
            q2.add(q1.remove());

        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
    }

    public int popMethod1() {
        if (q1.isEmpty()) return -1;
        return q1.remove();
    }

    public void pushMethod2(int x) {
        q1.add(x);
    }

    public int popMethod2() {
        if (q1.isEmpty()) return -1;
        while (q1.size() > 1)
            q2.add(q1.remove());

        int res = q1.remove();
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
        return res;
    }

    public static void main(String[] args) {
        TwoQueueStack s1 = new TwoQueueStack();
        System.out.println("Method 1 (Costly Push):");
        s1.pushMethod1(10);
        s1.pushMethod1(20);
        System.out.println(s1.popMethod1());
        System.out.println(s1.popMethod1());

        TwoQueueStack s2 = new TwoQueueStack();
        System.out.println("\nMethod 2 (Costly Pop):");
        s2.pushMethod2(100);
        s2.pushMethod2(200);
        System.out.println(s2.popMethod2());
        System.out.println(s2.popMethod2());
    }

}
