import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = null;
        while (true) {
            line = br.readLine();
            if ("0 0".equals(line)) {
                System.out.println("AXIS");
                break;
            }
            String[] tokens = line.split(" ");
            double x = Double.parseDouble(tokens[0]);
            double y = Double.parseDouble(tokens[1]);
            if (x == 0 || y == 0) {
                System.out.println("AXIS");
            } else if (x > 0 && y > 0) {
                System.out.println("Q1");
            } else if (x < 0 && y > 0) {
                System.out.println("Q2");
            } else if (x < 0 && y < 0) {
                System.out.println("Q3");
            } else if (x > 0 && y < 0) {
                System.out.println("Q4");
            }
        }
    }
}
