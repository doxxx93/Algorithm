import java.io.*;

class Solution {

    static int n;
    static char[] arr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int test_case = 1; test_case <= 10; test_case++) {
            n = Integer.parseInt(br.readLine());
            arr = new char[n + 1];
            for (int i = 1; i <= n; i++) {
                String[] input = br.readLine().split(" ");
                arr[i] = input[1].charAt(0);
            }
            sb.append("#").append(test_case).append(" ");
            inorder(1);
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static void inorder(int x) {
        if (x > n) {
            return;
        }
        inorder(2 * x);
        sb.append(arr[x]);
        inorder(2 * x + 1);
    }
}
