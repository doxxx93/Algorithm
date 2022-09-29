import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());
        n %= 5;
        if (n == 0 || n == 2) {
            System.out.println("CY");
        } else {
            System.out.println("SK");
        }
    }
}
