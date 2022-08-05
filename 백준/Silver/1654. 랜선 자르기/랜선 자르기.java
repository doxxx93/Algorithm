import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        List<Integer> lines = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            lines.add(Integer.parseInt(br.readLine()));
        }

        long s = 0;
        long e = Integer.MAX_VALUE;

        long answer = 0;

        while (s <= e) {
            long mid = (s+e)/2;
            long count = 0;
            for (Integer line : lines) {
                count += line/mid;
            }
            if (count >= n) {
                answer = mid;
                s = mid+1;
            } else {
                e = mid-1;
            }
        }
        System.out.println(answer);
    }
}