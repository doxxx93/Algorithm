import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<String> numbers = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            numbers.add(st.nextToken());
        }
        numbers.sort((o1, o2) -> (o2 + o1).compareTo(o1 + o2));
        StringBuilder sb = new StringBuilder();
        if (numbers.get(0).equals("0")) {
            sb.append("0");
        } else {
            for (int i = 0; i < n; i++) {
                sb.append(numbers.get(i));
            }
        }
        System.out.println(sb);
    }
}
