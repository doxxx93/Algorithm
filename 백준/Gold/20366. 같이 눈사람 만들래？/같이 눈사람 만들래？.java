import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int answer = Integer.MAX_VALUE;

        for (int es = 0; es < n; es++) {
            for (int ee = n - 1; ee > es; ee--) {
                int result = arr[es] + arr[ee];
                int as = 0;
                int ae = n - 1;

                while (as < ae) {
                    if (as == es || as == ee) {
                        as++;
                        continue;
                    }
                    if (ae == ee || ae == es) {
                        ae--;
                        continue;
                    }
                    int res = arr[as] + arr[ae];
                    answer = Math.min(answer, Math.abs(result - res));

                    if (result < res) {
                        ae--;
                    } else if (result > res) {
                        as++;
                    } else {
                        break;
                    }
                }
            }
        }
        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }
}
