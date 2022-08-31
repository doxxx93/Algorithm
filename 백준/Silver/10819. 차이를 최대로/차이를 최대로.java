import java.io.*;
import java.util.*;

public class Main {

    static int n, answer;
    static int[] input;
    static int[] numbers;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 3<= n <= 8
        // |A[0] - A[1]| + |A[1] - A[2]| + ... + |A[n-2] - A[n-1]| 의 최댓값
        n = Integer.parseInt(br.readLine());
        input = new int[n];
        numbers = new int[n];
        visited = new boolean[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0);
        System.out.println(answer);
    }

    private static void dfs(int count) {
        if (count == n) {
            int sum = 0;
            for (int i = 0; i < n - 1; i++) {
                sum += Math.abs(numbers[i] - numbers[i + 1]);
            }
            answer = Math.max(answer, sum);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                numbers[count] = input[i];
                dfs(count + 1);
                visited[i] = false;
            }
        }
    }
}
