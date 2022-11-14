import java.io.*;
import java.math.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(new BigInteger(br.readLine(), 2).multiply(BigInteger.valueOf(17)).toString(2));
    }
}
