import java.io. *;
import java.util. *;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        Map<Integer, Integer> sum = new TreeMap<>();
        for (int i = 1; i <= a; i++) {
            for (int j = 1; j <= b; j++) {
                for (int k = 1; k <= c; k++) {
                    int s = i + j + k;
                    sum.put(s, sum.getOrDefault(s, 0) + 1);
                }
            }
        }
        System.out.println(sum.entrySet().stream().max(Map.Entry.comparingByValue()).get().getKey());
    }
}
