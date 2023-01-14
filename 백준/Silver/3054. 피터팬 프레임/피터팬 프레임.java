
import java.util.Scanner;

public class Main {
    static StringBuilder[] output = new StringBuilder[5];

    static int abs(int x) {
        return x < 0 ? -x : x;
    }

    static void crtaj(char x, int c, char y) {
        output[2].setCharAt(c, x);
        for (int dr = -2; dr <= 2; dr++) {
            for (int dc = -2; dc <= 2; dc++) {
                if (abs(dr) + abs(dc) == 2) {
                    output[2 + dr].setCharAt(c + dc, y);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] s = scanner.nextLine().toCharArray();

        int n = s.length;

        for (int i = 0; i < 5; i++) {
            output[i] = new StringBuilder();
            for (int j = 0; j <= 4 * n; j++) {
                output[i].append(".");
            }
        }

        for (int i = 0; i < n; i++) {
            crtaj(s[i], 4 * i + 2, '#');
        }
        for (int i = 2; i < n; i += 3) {
            crtaj(s[i], 4 * i + 2, '*');
        }

        for (int i = 0; i < 5; i++) {
            System.out.println(output[i].toString());
        }
    }
}
