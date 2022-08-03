import java.io.*;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            List<Integer> dots = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                dots.add(Integer.parseInt(st.nextToken()));
            }
            Collections.sort(dots);
            int count = 0;

            for (int a = 0; a < n - 2; a++) {
                int c = a + 2;
                for (int b = a + 1; b < n - 1; b++) {
                    int diff = dots.get(b) - dots.get(a);

                    while (c < n && dots.get(c)-dots.get(b) < diff) {
                        c++;
                    }
                    if (c == n) {
                        break;
                    }
                    if (dots.get(c) - dots.get(b) == diff) {
                        count++;
                    }
                }
            }
            sb.append(count).append("\n");
        }
        System.out.println(sb);
    }
}