import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean[] zodiac = new boolean[12];
        StringTokenizer st;
        for (int i = 0; i < 7; i++) {
            st = new StringTokenizer(br.readLine());
            int month = Integer.parseInt(st.nextToken());
            int day = Integer.parseInt(st.nextToken());
            int join = checkJoin(month, day);
            zodiac[join] = true;
        }

        int n = Integer.parseInt(br.readLine());
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int month = Integer.parseInt(st.nextToken());
            int day = Integer.parseInt(st.nextToken());
            int join = checkJoin(month, day);
            if (!zodiac[join]) {
                list.add(new int[]{month, day});
            }
        }
        if (list.isEmpty()) {
            System.out.println("ALL FAILED");
        } else {
            list.sort((o1, o2) -> {
                if (o1[0] == o2[0]) {
                    return o1[1] - o2[1];
                }
                return o1[0] - o2[0];
            });
            for (int[] arr : list) {
                System.out.println(arr[0] + " " + arr[1]);
            }
        }
    }

    public static int checkJoin(int month, int day) {
        if (month == 1) {
            if (day < 20) {
                return 11;
            } else {
                return 0;
            }
        } else if (month == 2) {
            if (day < 19) {
                return 0;
            } else {
                return 1;
            }
        } else if (month == 3) {
            if (day < 21) {
                return 1;
            } else {
                return 2;
            }
        } else if (month == 4) {
            if (day < 20) {
                return 2;
            } else {
                return 3;
            }
        } else if (month == 5) {
            if (day < 21) {
                return 3;
            } else {
                return 4;
            }
        } else if (month == 6) {
            if (day < 22) {
                return 4;
            } else {
                return 5;
            }
        } else if (month == 7) {
            if (day < 23) {
                return 5;
            } else {
                return 6;
            }
        } else if (month == 8) {
            if (day < 23) {
                return 6;
            } else {
                return 7;
            }
        } else if (month == 9) {
            if (day < 23) {
                return 7;
            } else {
                return 8;
            }
        } else if (month == 10) {
            if (day < 23) {
                return 8;
            } else {
                return 9;
            }
        } else if (month == 11) {
            if (day < 23) {
                return 9;
            } else {
                return 10;
            }
        } else {
            if (day < 22) {
                return 10;
            } else {
                return 11;
            }
        }
    }
}
