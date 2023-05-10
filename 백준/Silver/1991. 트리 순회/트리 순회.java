import java.io.*;
import java.util.stream.*;

public class Main {

    static int n;
    static Node[] tree;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        tree = IntStream.range(0, n).mapToObj(i -> new Node((char) ('A' + i))).toArray(Node[]::new);
        while (n-- > 0) {
            char[] input = br.readLine().toCharArray();
            char data = input[0];
            char left = input[2];
            char right = input[4];
            if (left != '.') {
                tree[data - 'A'].left = tree[left - 'A'];
            }
            if (right != '.') {
                tree[data - 'A'].right = tree[right - 'A'];
            }
        }
        preorder(tree[0]);
        sb.append("\n");
        inorder(tree[0]);
        sb.append("\n");
        postorder(tree[0]);
        System.out.println(sb);
    }

    static void preorder(Node node) {
        if (node == null) {
            return;
        }
        sb.append(node.data);
        preorder(node.left);
        preorder(node.right);
    }
    
    static void inorder(Node node) {
        if (node == null) {
            return;
        }
        inorder(node.left);
        sb.append(node.data);
        inorder(node.right);
    }
    
    static void postorder(Node node) {
        if (node == null) {
            return;
        }
        postorder(node.left);
        postorder(node.right);
        sb.append(node.data);
    }

    static class Node {

        char data;
        Node left;
        Node right;

        public Node(char data) {
            this.data = data;
        }
    }
}
