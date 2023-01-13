import java.io.*;

public class Main {

    static char[] fourAndSeven = {'4', '7'};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine()) + 1;
        StringBuilder sb = new StringBuilder();
        int temp;
        while (k > 0) {
            temp = k % 2;
            sb.append(fourAndSeven[temp]);
            k /= 2;
        }
        System.out.println(sb.deleteCharAt(sb.length() - 1).reverse());
    }
}
