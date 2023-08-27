import java.io.*;
import java.util.*;

public class Main {

    static List<Character> ops;
    static List<Integer> numbers;
    static int answer = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String input = br.readLine();
        numbers = new ArrayList<>();
        ops = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                numbers.add(input.charAt(i) - '0');
            } else {
                ops.add(input.charAt(i));
            }
        }

        dfs(0, numbers.get(0));
        System.out.println(answer);
    }

    private static void dfs(int index, int result) {
        if (index >= ops.size()) {
            answer = Math.max(result, answer);
            return;
        }

        dfs(index + 1, calculate(result, numbers.get(index + 1), ops.get(index)));

        if (index + 1 >= ops.size()) {
            return;
        }
        dfs(index + 2, calculate(result, calculate(numbers.get(index + 1), numbers.get(index + 2),
            ops.get(index + 1)), ops.get(index)));
    }

    private static int calculate(int x, int y, char op) {
        if (op == '+') {
            return x + y;
        } else if (op == '-') {
            return x - y;
        }
        return x * y;
    }
}
