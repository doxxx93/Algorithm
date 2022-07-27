import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        Arrays.sort(arr);

        StringBuilder sb = new StringBuilder();

        int M = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < M; i++) {
            int target = Integer.parseInt(st.nextToken());
            if (Arrays.binarySearch(arr, target) < 0) {
                sb.append(0).append(" ");
            } else {
                sb.append(1).append(" ");
            }
        }
        System.out.println(sb);
    }
}