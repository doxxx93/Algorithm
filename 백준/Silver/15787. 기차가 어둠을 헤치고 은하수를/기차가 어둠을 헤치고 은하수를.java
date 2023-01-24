import static java.util.Arrays.*;

import java.io.*;


public class Main {

    static int n, m;
    static int[] trains;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = stream(br.readLine().split(" "))
            .mapToInt(Integer::parseInt)
            .toArray();
        n = input[0];
        m = input[1];
        trains = new int[n + 1];

        for (int i = 0; i < m; i++) { // command

            input = stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

            int command = input[0];
            int index = input[1];
            int seat = input.length == 2 ? 0 : input[2];

            switch (command) {
                case 1:
                    trains[index] |= (1 << seat);
                    break;
                case 2:
                    trains[index] &= ~(1 << seat);
                    break;
                case 3:
                    trains[index] <<= 1;
                    trains[index] &= ((1 << 21) - 1);
                    break;
                case 4:
                    trains[index] >>= 1;
                    trains[index] &= ~1;
                    break;
            }
        }

        int ans = (int) stream(trains, 1, n + 1)
            .distinct()
            .count();

        System.out.println(ans);
    }
}
