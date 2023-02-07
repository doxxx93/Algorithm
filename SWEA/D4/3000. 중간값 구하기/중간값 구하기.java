import java.io.*;
import java.util.*;

class Solution {

    private static final int MOD = 20171109;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        for (int test_case = 1; test_case <= T; test_case++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            PriorityQueue<Integer> minHeap = new PriorityQueue<>();
            PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
            maxHeap.add(x);
            int sum = 0;
            for (int i = 0; i <n; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                if (a > maxHeap.peek()) {
                    minHeap.add(a);
                } else {
                    maxHeap.add(a);
                }
                if (b > maxHeap.peek()) {
                    minHeap.add(b);
                } else {
                    maxHeap.add(b);
                }

                if (minHeap.size() > maxHeap.size()) {
                    maxHeap.add(minHeap.poll());
                } else if (maxHeap.size() - minHeap.size() > 1) {
                    minHeap.add(maxHeap.poll());
                }
                sum += maxHeap.peek();
                sum %= MOD;
            }
            sb.append("#").append(test_case).append(" ").append(sum).append("\n");
        }
        System.out.println(sb);
    }
}