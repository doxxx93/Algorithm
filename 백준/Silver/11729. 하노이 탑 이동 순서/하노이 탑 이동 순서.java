import java.io.*;
import java.util.*;

public class Main {

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int from = 1;
        int empty = 2;
        int to = 3;
        sb.append((int)(Math.pow(2,n)-1)).append("\n");
        hanoi(n, 1, 2, 3);
        System.out.println(sb.toString());
    }

    private static void hanoi(int n,int from, int empty,int to ) {
        if (n == 1) {
            sb.append(from).append(" ").append(to).append("\n");
            return;
        }
        hanoi(n - 1, from, to, empty);
        sb.append(from).append(" ").append(to).append("\n");
        hanoi(n-1, empty, from, to);
    }
}