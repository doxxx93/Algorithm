import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String a = br.readLine();
        String b = br.readLine();
        if (a.length() < b.length()) {
            System.out.println("no");
            return;
        }
        System.out.println("go");
    }
}
