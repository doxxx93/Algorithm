import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) {
                break;
            }
            PriorityQueue<String> pq = new PriorityQueue<>(String::compareToIgnoreCase);

            for (int i = 0; i < n; i++) {
                pq.add(br.readLine());
            }
            sb.append(pq.poll()).append("\n");
        }
        System.out.print(sb);
    }
}