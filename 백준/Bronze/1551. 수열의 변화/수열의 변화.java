import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] arr = Arrays.stream(br.readLine().split(",")).mapToInt(Integer::parseInt)
            .toArray();
        System.out.println(
            Arrays.toString(dfs(arr, k, 0)).replace(",", ",").replace("[", "").replace("]", "")
                .replace(" ", ""));
    }

    private static int[] dfs(int[] arr, int k, int depth) {
        if (depth == k) {
            return arr;
        }
        int[] result = new int[arr.length - 1];
        for (int i = 0; i < arr.length - 1; i++) {
            result[i] = arr[i + 1] - arr[i];
        }
        return dfs(result, k, depth + 1);
    }
}