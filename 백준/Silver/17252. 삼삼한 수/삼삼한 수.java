import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        if (n == 0) {
            System.out.println("NO");
            return;
        }
        String ternary = Integer.toString(n, 3);
        for (int i = 0; i < ternary.length(); i++) {
            if (ternary.charAt(i) == '2') {
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }
}
