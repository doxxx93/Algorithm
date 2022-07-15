import java.io.*;
import java.util.*;
import java.util.stream.Collectors;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int a = Integer.parseInt(st.nextToken());

        int x = n / a;
        int answer = x;
        while (x >= a) {
            x = x / a;
            answer += x;
        }
        System.out.println(answer);
    }
}