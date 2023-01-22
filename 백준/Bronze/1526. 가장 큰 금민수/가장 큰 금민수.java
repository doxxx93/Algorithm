import java.io.*;

public class Main {

    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        System.out.println(dfs(0));
    }

    private static int dfs(int number) {
        int value = number;
        if (number * 10 + 4 <= n) {
            value = dfs(number * 10 + 4);
        }
        if (number * 10 + 7 <= n) {
            value = Math.max(value, dfs(number * 10 + 7));
        }
        return value;
    }
}
