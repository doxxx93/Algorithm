import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> fib = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int first = Integer.parseInt(st.nextToken());
        int second = Integer.parseInt(st.nextToken());
        fib.add(first);
        fib.add(second);
        fib.add((first + second) % 10);
        while (fib.get(fib.size() - 2) != first || fib.get(fib.size() - 1) != second) {
            fib.add((fib.get(fib.size() - 1) + fib.get(fib.size() - 2)) % 10);
        }
        System.out.println(fib.size());
    }
}