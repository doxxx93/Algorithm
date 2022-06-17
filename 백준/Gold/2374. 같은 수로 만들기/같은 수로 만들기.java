import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Stack<Long> stack = new Stack<>();

        long max = 0;
        long answer = 0;

        while (n-- > 0) {
            long num = Long.parseLong(br.readLine());
            max = Math.max(max, num);

            if (stack.isEmpty()) {
                stack.push(num);
            } else {
                if (stack.peek() < num) {
                    answer += num - stack.pop();
                    stack.push(num);
                } else if (stack.peek() > num) {
                    stack.pop();
                    stack.push(num);
                }
            }
        }
        while (!stack.isEmpty()) {
            answer += max - stack.pop();
        }
        System.out.println(answer);
    }
}