import java.io.*;
import java.math.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BigInteger input = new BigInteger(br.readLine(), 2);
        System.out.println(input.toString(8));
    }
}
