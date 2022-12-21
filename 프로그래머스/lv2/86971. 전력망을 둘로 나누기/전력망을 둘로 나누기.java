import java.util.*;

class Solution {

    boolean[] visited;

    public int solution(int n, int[][] wires) {
        visited = new boolean[n + 1];

        int answer = Integer.MAX_VALUE;

        for (int[] wire : wires) {
            Arrays.fill(visited, false);
            int a = wire[0];
            int b = wire[1];
            visited[a] = true;
            visited[b] = true;
            answer = Math.min(answer, Math.abs(dfs(a, wires, 1) - dfs(b, wires, 1)));
        }
        return answer;
    }

    private int dfs(int start, int[][] wires, int count) {
        for (int[] wire : wires) {
            if (wire[0] == start && !visited[wire[1]]) {
                visited[wire[1]] = true;
                count = dfs(wire[1], wires, count + 1);
            } else if (wire[1] == start && !visited[wire[0]]) {
                visited[wire[0]] = true;
                count = dfs(wire[0], wires, count + 1);
            }
        }
        return count;
    }
}
