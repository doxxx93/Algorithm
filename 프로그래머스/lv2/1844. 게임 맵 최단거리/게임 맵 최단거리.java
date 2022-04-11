import java.util.LinkedList;
import java.util.Queue;

class Solution {

    int[][] maps, distance;
    int height, width;

    public int solution(int[][] maps) {
        this.maps = maps;
        height = maps.length;
        width = maps[0].length;
        distance = new int[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                distance[i][j] = -1;
            }
        }
        bfs();
        return distance[height - 1][width - 1];
    }

    void bfs() {
        int[] dy = {1, -1, 0, 0}, dx = {0, 0, 1, -1};
        distance[0][0] = 1;
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(0, 0));
        while (!q.isEmpty()) {
            Node curr = q.poll();
            for (int d = 0; d < 4; d++) {
                Node next = new Node(curr.y + dy[d], curr.x + dx[d]);
                if (0 <= next.y && next.y < maps.length && 0 <= next.x && next.x < maps[0].length) {
                    if (distance[next.y][next.x] == -1 && maps[next.y][next.x] == 1) {
                        distance[next.y][next.x] = distance[curr.y][curr.x] + 1;
                        q.add(next);
                    }
                }
            }
        }
    }
}

class Node {

    int y, x;

    Node(int y, int x) {
        this.y = y;
        this.x = x;
    }
}