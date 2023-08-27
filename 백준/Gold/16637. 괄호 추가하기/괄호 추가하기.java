import java.io.*;
import java.util.*;

public class Main {

    static List<Character> operators;
    static List<Integer> operands;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String input = br.readLine();

        operands = new ArrayList<>();
        operators = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            char c = input.charAt(i);
            if (Character.isDigit(c)) {
                operands.add(c - '0');
            } else {
                operators.add(c);
            }
        }

        solve(0, operands.get(0));

        System.out.println(max);
    }

    private static void solve(int index, int result) {
        if (index >= operators.size()) {
            max = Math.max(result, max);
            return;
        }

        // Consider the priority of the next operation
        if (index + 1 < operators.size()) {
            int nextResult = calc(operands.get(index + 1), operands.get(index + 2), operators.get(index + 1));
            solve(index + 2, calc(result, nextResult, operators.get(index)));
        }

        // Next operation without considering priority
        solve(index + 1, calc(result, operands.get(index + 1), operators.get(index)));
    }

    private static int calc(int a, int b, char op) {
        if (op == '+') {
            return a + b;
        } else if (op == '-') {
            return a - b;
        }
        return a * b;
    }
}
