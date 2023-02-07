import java.io.*;
import java.util.*;

class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        for (int test_case = 1; test_case <= T; test_case++) {
            int n = Integer.parseInt(br.readLine());
            int[] a = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
            }
            int k = Integer.parseInt(br.readLine());

            int answer = 0;
            PriorityQueue<Node> pq = new PriorityQueue<>();
            pq.add(new Node(k, 0));
            while (!pq.isEmpty()) {
                Node node = pq.poll();
                int count = node.count;
                int left = node.left;
                if (left == 0) {
                    answer = count;
                    break;
                }
                boolean flag = false;
                for (int i = 0; i < n; i++) {
                    if (left - a[i] >= 0) {
                        pq.add(new Node(left / a[i], count + left % a[i]));
                        flag = true;
                    }
                }
                if (!flag) {
                    pq.add(new Node(0, count + left));
                }
            }

            sb.append("#").append(test_case).append(" ").append(answer).append("\n");
        }
        System.out.println(sb);
    }

    static class Node implements Comparable<Node> {

        int left;
        int count;

        Node(int left, int count) {
            this.left = left;
            this.count = count;
        }

        @Override
        public int compareTo(Node o) {
            if (this.count == o.count) {
                return this.left - o.left;
            }
            return this.count - o.count;
        }
    }
}
/*
a[]: 2 3
k: 7

x: 0
d: 1
count: 0

 */