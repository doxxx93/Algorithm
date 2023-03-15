import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            sb.append(" ".repeat(n - i - 1));
            sb.append("*".repeat(Math.max(0, 2 * i + 1)));
            sb.append("\n");
        }
        for (int i = 0; i < n - 1; i++) {
            sb.append(" ".repeat(i + 1));
            sb.append("*".repeat(Math.max(0, 2 * (n - i - 1) - 1)));
            sb.append("\n");
        }
        System.out.println(sb);
    }
}