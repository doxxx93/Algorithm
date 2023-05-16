import java.io.*;
import java.util.*;

/*
 inorder and postorder are given
 than print preorder
 there are 1 to n nodes
 input like
 n
 inorder
 postorder
 3
 1 2 3
 1 3 2
 output
 2 1 3
*/
public class Main {

    static int n;
    static ArrayList<Integer>[] tree;
    static int[] inorder;
    static int[] postorder;
    static int[] preorder;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        inorder = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        postorder = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        tree = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            tree[i] = new ArrayList<>();
        }
        for (int i = 0; i < n; i++) {
            tree[inorder[i]].add(i);
        }
        preorder = new int[n];
        dfs(0, n - 1, 0, n - 1, 0);
        for (int i = 0; i < n; i++) {
            System.out.print(preorder[i] + " ");
        }
    }

    static void dfs(int inStart, int inEnd, int postStart, int postEnd, int preStart) {
        if (inStart > inEnd || postStart > postEnd) {
            return;
        }
        int root = postorder[postEnd];
        preorder[preStart] = root;
        int rootIndex = tree[root].get(0);
        int left = rootIndex - inStart;
        dfs(inStart, rootIndex - 1, postStart, postStart + left - 1, preStart + 1);
        dfs(rootIndex + 1, inEnd, postStart + left, postEnd - 1, preStart + left + 1);
    }
}
