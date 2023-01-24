import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Node {
    int data;
    int left;
    int right;
    String op;
}

public class Solution {
    public static Node[] node = new Node[10000];
    public static int len;
    public static int result;

    public static int postOrder(int cur) {
        String op = node[cur].op;

        if (op != null && op.equals("+"))
            result = postOrder(node[cur].left) + postOrder(node[cur].right);
        else if (op != null && op.equals("-"))
            result = postOrder(node[cur].left) - postOrder(node[cur].right);
        else if (op != null && op.equals("*"))
            result = postOrder(node[cur].left) * postOrder(node[cur].right);
        else if (op != null && op.equals("/"))
            result = postOrder(node[cur].left) / postOrder(node[cur].right);
        else result = node[cur].data;

        return result;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for (int test_case = 1; test_case <= 10; test_case++) {
            len = Integer.parseInt(br.readLine());

            for (int i = 1; i <= len; i++) node[i] = new Node();

            for (int i = 0; i < len; i++) {
                st = new StringTokenizer(br.readLine());
                int idx = Integer.parseInt(st.nextToken());
                String op = st.nextToken();
                if (op.equals("+") || op.equals("-") || op.equals("*") || op.equals("/")) {
                    node[idx].op = op;
                    node[idx].left = Integer.parseInt(st.nextToken());
                    node[idx].right = Integer.parseInt(st.nextToken());
                }
                else node[idx].data = Integer.parseInt(op);
            }
            sb.append("#").append(test_case).append(" ").append(postOrder(1)).append("\n");
        }
        System.out.println(sb);
    }
}
