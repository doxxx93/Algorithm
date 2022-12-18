import java.io.*;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int x = Integer.parseInt(br.readLine());
        System.out.println(recur(x, 0));
    }

    static int recur(int x, int count) {
        if (x < 2) {
            return count;
        }
        return Math.min(recur(x / 2, count + 1 + (x % 2)), recur(x / 3, count + 1 + (x % 3)));
    }
}