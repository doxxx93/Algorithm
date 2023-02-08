import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] arr2 = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            arr2[i] = Integer.parseInt(st.nextToken());
        }

        int s1 = 0;
        int s2 = 0;

        StringBuilder sb = new StringBuilder();

        while (s1 < n && s2 < m) {
            if (arr[s1] < arr2[s2]) {
                sb.append(arr[s1]).append(" ");
                s1++;
            } else {
                sb.append(arr2[s2]).append(" ");
                s2++;
            }
        }
        for (int i = s1; i < n; i++) {
            sb.append(arr[i]).append(" ");
        }
        for (int i = s2; i < m; i++) {
            sb.append(arr2[i]).append(" ");
        }

        System.out.println(sb);
    }
}
