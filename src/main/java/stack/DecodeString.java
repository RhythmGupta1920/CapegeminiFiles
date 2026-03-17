package stack;
import java.util.Stack;
import java.util.Scanner;

public class DecodeString {
    public static void main(String args[]) {
        Scanner sc  = new Scanner(System.in);
        String input = sc.nextLine();
        decode(input);
        sc.close();
    }

    public static void decode(String input) {
        Stack<String> s = new Stack<>();
        String ans = "";

        for(int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);

            if(ch == '[' ||
                    ch >= 'a' && ch <= 'z' ||
                    ch >= 'A' && ch <= 'Z' ||
                    ch >= '0' && ch <= '9'
            ) {
                s.push(String.valueOf(ch));
            }
            else if(ch == ']') {
                ans = "";
                while(!s.isEmpty() &&
                        !s.peek().equals("[")) {
                    ans = s.pop()+ans ;
                }

                s.pop();
                if(s.peek().charAt(0) >= '0' &&
                        s.peek().charAt(0) <= '9') {
                    int j = Integer.parseInt(s.pop());
                    String temp = ans;

                    while(j > 1) {
                        temp = temp+ans;
                        j--;
                    }

                    s.push(temp);
                }
            }

        }

        ans = "";
        while(!s.isEmpty())
            ans = s.pop() + ans;

        System.out.println(ans);
    }
}
