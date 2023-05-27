import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(IntStream.range(0, Integer.parseInt(br.readLine()))
            .map(i -> {
                try {
                    return Integer.parseInt(br.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            })
            .sum());
    }
}
