import java.io.*;
import java.util.*;

class Main {

    static String[] correctDigits = {
        "####.##.##.####",
        "..#..#..#..#..#",
        "###..#####..###",
        "###..####..####",
        "#.##.####..#..#",
        "####..###..####",
        "####..####.####",
        "###..#..#..#..#",
        "####.#####.####",
        "####.####..####"};
    static String[] clock;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        clock = new String[4];
        Arrays.fill(clock, "");
        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 4; j++) {
                clock[j] = clock[j]+ st.nextToken();
            }
        }

        for (int i = 0; i < 24; i++) {
            for (int j = 0; j < 60; j++) {
                if (match(0, i / 10) && match(1, i % 10) && match(2, j / 10) && match(3, j % 10)) {
                    System.out.printf("%02d:%02d%n", i, j);
                    return;
                }
            }
        }
    }

    private static boolean match(int digit, int number) {
        for (int i = 0; i < 15; i++) {
            if (clock[digit].charAt(i) == '#' && correctDigits[number].charAt(i) == '.') {
                return false;
            }
        }
        return true;
    }
}
