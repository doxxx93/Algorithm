import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] towers = new int[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i < n + 1; i++) {
            towers[i] = Integer.parseInt(st.nextToken());
        }
        Stack<Integer> stack = new Stack<>();
        int[] answer = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            while (!stack.empty()) {
                if (towers[stack.peek()] > towers[i]) {
                    answer[i] = stack.peek();
                    break;
                }
                stack.pop();
            }
            stack.push(i);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < n + 1; i++) {
            sb.append(answer[i]).append(" ");
        }
        System.out.println(sb);
    }
}
