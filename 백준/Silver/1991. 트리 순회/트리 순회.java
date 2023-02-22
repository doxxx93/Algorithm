import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {

    static Node[] tree;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        tree = IntStream.range(0, n).mapToObj(i -> new Node((char) ('A' + i))).toArray(Node[]::new);
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            char root = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);
            if (left != '.') {
                tree[root - 'A'].left = tree[left - 'A'];
            }
            if (right != '.') {
                tree[root - 'A'].right = tree[right - 'A'];
            }
        }
        preOrder(tree[0]);
        sb.append("\n");
        inOrder(tree[0]);
        sb.append("\n");
        postOrder(tree[0]);
        System.out.println(sb);
    }

    private static void preOrder(Node node) {
        sb.append(node.data);
        if (node.left != null) {
            preOrder(node.left);
        }
        if (node.right != null) {
            preOrder(node.right);
        }
    }

    private static void inOrder(Node node) {
        if (node.left != null) {
            inOrder(node.left);
        }
        sb.append(node.data);
        if (node.right != null) {
            inOrder(node.right);
        }
    }

    private static void postOrder(Node node) {
        if (node.left != null) {
            postOrder(node.left);
        }
        if (node.right != null) {
            postOrder(node.right);
        }
        sb.append(node.data);
    }

    static class Node {

        Node left, right;
        char data;

        public Node(char data) {
            this.data = data;
        }
    }
}