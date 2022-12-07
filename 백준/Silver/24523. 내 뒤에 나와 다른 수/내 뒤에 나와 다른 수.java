import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n + 1];
        int[] answer = new int[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i < n + 1; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int index = -1;
        for (int i = n; i > 0; i--) {
            answer[i] = index;
            if (arr[i - 1] != arr[i]) {
                index = i;
            }
        }
        answer[0] = index;
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < n + 1; i++) {
            sb.append(answer[i]).append(" ");
        }
        System.out.println(sb);
    }
}
