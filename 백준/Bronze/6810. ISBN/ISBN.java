import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int result = 91;
        result += Integer.parseInt(br.readLine());
        result += Integer.parseInt(br.readLine()) * 3;
        result += Integer.parseInt(br.readLine());
        System.out.printf("The 1-3-sum is %d\n", result);
    }
}
