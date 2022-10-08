import java.io.*;
import java.math.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        BigInteger a = new BigInteger(br.readLine());
        BigInteger b = new BigInteger(br.readLine());
        BigInteger x = a.subtract(b).divide(BigInteger.valueOf(2));
        System.out.println(x.add(b));
        System.out.println(x);
    }
}
