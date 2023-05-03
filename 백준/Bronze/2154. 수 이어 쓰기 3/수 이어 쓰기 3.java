import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String n = br.readLine();
        var sb = new StringBuilder();
        for (int i = 1; i <= Integer.parseInt(n); i++) {
            sb.append(i);
        }
        System.out.println(sb.indexOf(n) + 1);
    }
}