import java.io.*;

public class Main {

    static final int c = 10;
    static final int b = 60;
    static final int a = 300;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        if (t % c != 0) {
            System.out.println(-1);
            return;
        }
        if (t >= a) {
            sb.append(t / a).append(" ");
            t %= a;
        } else {
            sb.append(0).append(" ");
        }
        if (t >= b) {
            sb.append(t / b).append(" ");
            t %= b;
        } else {
            sb.append(0).append(" ");
        }
        if (t >= c) {
            sb.append(t / c);
        } else {
            sb.append(0).append(" ");
        }
        System.out.println(sb);
    }
}
