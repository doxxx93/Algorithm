import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;
        while (!(input = br.readLine()).equals("# 0 0")) {
            String name= input.split(" ")[0];
            int age = Integer.parseInt(input.split(" ")[1]);
            int weight = Integer.parseInt(input.split(" ")[2]);
            if (age > 17 || weight >= 80) {
                System.out.println(name + " Senior");
            } else {
                System.out.println(name + " Junior");
            }
        }
    }
}
