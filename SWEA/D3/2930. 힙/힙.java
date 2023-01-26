import java.util.*;

/**
 * 최대 힙 구현 문제
 * 연산 1: x를 삽입
 * 연산 2: 최대 힙의 루트 노드의 키값 출력, 삭제
 */
class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int tc = 1; tc <= t; tc++) {
            sb.append("#").append(tc);
            pq.clear();
            int n = sc.nextInt();
            for (int i = 0; i < n; i++) {
                int op = sc.nextInt();
                if (op == 1) {
                    pq.add(sc.nextInt());
                    continue;
                }
                if (pq.isEmpty()) {
                    sb.append(" ").append(-1);
                    continue;
                }
                sb.append(" ").append(pq.poll());
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
