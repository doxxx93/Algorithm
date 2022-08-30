import java.io.*;
import java.util.*;

public class Main {

    static int k;
    static boolean[] input;
    static boolean[] visited = new boolean[10];
    static int[] arr;
    static List<String> result;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        k = Integer.parseInt(br.readLine());
        input = new boolean[k];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            input[i] = st.nextToken().equals("<");
        }
        arr = new int[k + 1];
        result = new ArrayList<>();
        dfs(0);
        Collections.sort(result);
        System.out.println(result.get(result.size() - 1));
        System.out.println(result.get(0));
    }

    private static void dfs(int count) {
        if (count == k + 1) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < arr.length; i++) {
                sb.append(arr[i]);
            }
            result.add(sb.toString());
            return;
        }

        for (int i = 0; i < 10; i++) {
            if (visited[i]||(count > 0 && arr[count - 1] < i != input[count - 1])) {
                continue;
            }
            visited[i] = true;
            arr[count] = i;
            dfs(count + 1);
            visited[i] = false;
        }
    }
}
