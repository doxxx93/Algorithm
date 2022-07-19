import java.io.*;
import java.util.*;

public final class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long s = Long.parseLong(st.nextToken());
        long e = Long.parseLong(st.nextToken());

        long count = e - s + 1;
        boolean[] visited = new boolean[(int) count];

        for (long i = 2; i * i <= e; i++) {
            long power = i * i;
            long tmp = s / power;

            if (s%power != 0) {
                tmp++;
            }

            for (long j = tmp; j * power <= e; j++) {
                int root = (int) (j * power - s);
                if (!visited[root]) {
                    visited[root] = true;

                    count--;
                }
            }
        }
        System.out.println(count);
    }
}