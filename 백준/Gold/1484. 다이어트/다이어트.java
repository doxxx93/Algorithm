import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int g = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        int s = 1;
        int e = 1;
        while (e <= 50000) {
            if (e * e - s * s == g) {
                sb.append(e).append("\n");
                s++;
                e++;
            } else if (e * e - s * s < g) {
                e++;
            } else {
                s++;
            }
        }

        if (sb.length() == 0) {
            System.out.println(-1);
            return;
        }
        System.out.println(sb);
    }
}