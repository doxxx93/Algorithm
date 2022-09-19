import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int d = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        while (n-- > 1) {
            pq.add(Integer.parseInt(br.readLine()));
        }
        int count = 0;

        while (!pq.isEmpty() && pq.peek() >= d) {
            count++;
            d++;
            pq.add(pq.poll() - 1);
        }
        System.out.println(count);
    }
}
