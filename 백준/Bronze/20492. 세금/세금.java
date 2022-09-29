import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        System.out.println((int) ((1 - 0.22) * n));
        System.out.println((int) ((1 - 0.2 * 0.22) * n));
    }
}
