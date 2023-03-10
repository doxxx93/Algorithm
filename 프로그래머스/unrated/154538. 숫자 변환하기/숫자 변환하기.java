import java.util.*;

class Solution {

    public int solution(int x, int y, int n) {
        int count = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(x);
        boolean[] visited = new boolean[y + 1];
        visited[x] = true;
//        while (!queue.isEmpty()) {
//            int size = queue.size();
//            for (int i = 0; i < size; i++) {
//                int cur = queue.poll();
//                if (cur == y) {
//                    return count;
//                }
//                if (cur + n <= y && !visited.contains(cur + n)) {
//                    queue.add(cur + n);
//                    visited.add(cur + n);
//                }
//                if (cur * 2 <= y && !visited.contains(cur * 2)) {
//                    queue.add(cur * 2);
//                    visited.add(cur * 2);
//                }
//                if (cur * 3 <= y && !visited.contains(cur * 3)) {
//                    queue.add(cur * 3);
//                    visited.add(cur * 3);
//                }
//            }
//            count++;
//        }
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int cur = queue.poll();
                if (cur == y) {
                    return count;
                }
                if (cur + n <= y && !visited[cur + n]) {
                    queue.add(cur + n);
                    visited[cur + n] = true;
                }
                if (cur * 2 <= y && !visited[cur * 2]) {
                    queue.add(cur * 2);
                    visited[cur * 2] = true;
                }
                if (cur * 3 <= y && !visited[cur * 3]) {
                    queue.add(cur * 3);
                    visited[cur * 3] = true;
                }
            }
            count++;
        }
        return -1;
    }
}