import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean[] arr = new boolean[31];
        for (int i = 1; i < 29; i++) {
            arr[Integer.parseInt(br.readLine())] = true;
        }
        for (int i = 1; i < arr.length; i++) {
            if (!arr[i]) {
                System.out.println(i);
            }
        }
    }
}
