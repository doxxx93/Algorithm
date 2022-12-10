import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        long answer = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stack.empty() && arr[stack.peek()] < arr[i]) {
                answer += i - stack.peek() + 1;
                stack.pop();
            }
            if (!stack.empty()) {
                answer += i - stack.peek() + 1;
                if (arr[stack.peek()] == arr[i]) {
                    stack.pop();
                }
            }
            stack.push(i);
        }
        System.out.println(answer);
    }
}
