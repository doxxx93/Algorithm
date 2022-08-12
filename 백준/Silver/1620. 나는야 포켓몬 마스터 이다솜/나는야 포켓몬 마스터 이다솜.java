import java.io.*;
import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Map<String, Integer> siMap = new TreeMap<>();
        Map<Integer, String> isMap = new TreeMap<>();
        for (int i = 1; i < n + 1; i++) {
            String input = br.readLine();
            siMap.put(input, i);
            isMap.put(i, input);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            String input = br.readLine();
            if (siMap.containsKey(input)) {
                sb.append(siMap.get(input)).append("\n");
            } else {
                sb.append(isMap.get(Integer.parseInt(input))).append("\n");
            }
        }
        System.out.println(sb);
    }
}
