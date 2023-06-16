import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean isFBI = false;
        for (int i = 1; i <= 5; i++) {
            String line = br.readLine();
            if (line.contains("FBI")) {
                System.out.print(i + " ");
                isFBI = true;
            }
        }
        if (!isFBI) {
            System.out.println("HE GOT AWAY!");
        }
    }
}
