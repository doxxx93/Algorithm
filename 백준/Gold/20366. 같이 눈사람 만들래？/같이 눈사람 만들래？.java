import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        Arrays.sort(arr);

        int answer = Integer.MAX_VALUE;

        for (int as = 0; as < n; as++) {
            for (int ae = n - 1; ae > as; ae--) {
                int anna = arr[as] + arr[ae];
                int es = 0;
                int ee = n - 1;

                while (es < ee) {
                    if (es == as || es == ae) {
                        es++;
                        continue;
                    }
                    if (ee == ae || ee == as) {
                        ee--;
                        continue;
                    }
                    int elsa = arr[es] + arr[ee];
                    answer = Math.min(answer, Math.abs(anna - elsa));

                    if (anna > elsa) {
                        es++;
                    } else if (anna < elsa) {
                        ee--;
                    } else {
                        break;
                    }
                }
            }
        }
        System.out.println(answer);
    }
}