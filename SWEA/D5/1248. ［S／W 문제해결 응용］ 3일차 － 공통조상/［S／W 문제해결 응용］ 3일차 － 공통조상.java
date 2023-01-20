import java.io.*;
import java.util.*;

class Solution {

    static int v, e, x, y, size;
    static StringBuilder sb = new StringBuilder();
    static boolean[] visited;
    static Node[] nodes;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            st = new StringTokenizer(br.readLine());
            v = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());

            nodes = new Node[v + 1];
            visited = new boolean[v + 1];
            for (int i = 1; i <= v; i++) {
                nodes[i] = new Node(i);
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= e; i++) {
                int p = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                if (nodes[p].left == 0) {
                    nodes[p].left = c;
                } else {
                    nodes[p].right = c;
                }
                nodes[c].parent = p;
            }

            int lca = 1;
            while (true) {
                if (x != 1) {
                    int parent = nodes[x].parent;
                    if (visited[parent]) {
                        lca = parent;
                        break;
                    }
                    visited[parent] = true;
                    x = parent;
                }
                if (y != 1) {
                    int parent = nodes[y].parent;
                    if (visited[parent]) {
                        lca = parent;
                        break;
                    }
                    visited[parent] = true;
                    y = parent;
                }
            }
            size = 0;
            sizedOfSubtree(nodes[lca]);

            sb.append("#").append(test_case).append(" ").append(lca).append(" ").append(size)
                .append("\n");
        }
        System.out.println(sb);
    }

    private static void sizedOfSubtree(Node node) {
        if (node.left != 0) {
            sizedOfSubtree(nodes[node.left]);
        }
        if (node.right != 0) {
            sizedOfSubtree(nodes[node.right]);
        }
        size++;
    }

    private static class Node {

        int self, parent, left, right;

        public Node(int self) {
            this.self = self;
            this.parent = 0;
            this.left = 0;
            this.right = 0;
        }
    }
}
