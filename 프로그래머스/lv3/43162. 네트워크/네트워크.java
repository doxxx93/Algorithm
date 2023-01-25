/**
 * 관찰
 * A - B - C 일 때
 * 같은 네트워크 상에 있다.
 * 컴퓨터 개수 n, 1<= n <= 200
 * 연결에 대한 2차원 배열 computers
 * i번과 j번 연결되어 있으면 computers[i][j] = 1
 * 자기 자신은 항상 1
 * 1 1 0
 * 1 1 0
 * 0 0 1
 * 일땐 0과 1 이어져있음 2는 안이어져있음 -> answer = 2
 *
 * visited boolean 배열 통해서 이미 연결되어있으면 count 안되도록
 * 만약 0에서 dfs/bfs 돌리면 자기 자신을 어떻게 체크하지?
 *
 */
class Solution {

    boolean[] visited;

    public int solution(int n, int[][] computers) {
        visited = new boolean[n];
        int answer = 0;
        for (int i = 0; i < computers.length; i++) {
            if (visited[i]) {
                continue;
            }
            dfs(i, computers);
            answer++;
        }
        return answer;
    }

    private void dfs(int i, int[][] computers) {
        visited[i] = true;
        for (int j = 0; j < computers.length; j++) {
            if (i == j || computers[i][j] == 0 || visited[j]) {
                continue;
            }
            dfs(j, computers);
        }
    }
}
