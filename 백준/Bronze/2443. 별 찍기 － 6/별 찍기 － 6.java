import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(" ".repeat(i));
            sb.append("*".repeat(2 * n - 1 - 2 * i));
            sb.append("\n");
        }
        System.out.println(sb);
    }
}