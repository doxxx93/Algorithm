import java.io.*;
import java.util.*;

public class Main {

    static int n,min, max;
    static int[] numbers;
    static int[] operators;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        numbers = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt)
            .toArray();
        operators = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt)
            .toArray();
        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;
        dfs(1, numbers[0]);
        System.out.println(max);
        System.out.println(min);
    }

    private static void dfs(int i, int number) {
        if (i == n) {
            max = Math.max(max, number);
            min = Math.min(min, number);
            return;
        }
        for (int j = 0; j < 4; j++) {
            if (operators[j] > 0) {
                operators[j]--;
                switch (j) {
                    case 0:
                        dfs(i + 1, number + numbers[i]);
                        break;
                    case 1:
                        dfs(i + 1, number - numbers[i]);
                        break;
                    case 2:
                        dfs(i + 1, number * numbers[i]);
                        break;
                    case 3:
                        dfs(i + 1, number / numbers[i]);
                        break;
                }
                operators[j]++;
            }
        }
    }
}
