import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] start = new int[101];
        int[] end = new int[101];
        int[] time = new int[1001];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            start[i] = Integer.parseInt(st.nextToken());
            end[i] = Integer.parseInt(st.nextToken());
            for (int j = start[i]; j < end[i]; j++) {
                time[j]++;
            }
        }
        int answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = start[i]; j < end[i]; j++) {
                time[j]--;
            }
            int count = 0;
            for (int j = 0; j <= 1000; j++) {
                if (time[j] != 0) {
                    count++;
                }
            }
            answer = Math.max(answer, count);
            for (int j = start[i]; j < end[i]; j++) {
                time[j]++;
            }
        }
        System.out.println(answer);
    }
}
