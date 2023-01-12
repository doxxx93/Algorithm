import java.io.*;
import java.util.*;

public class Main {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        while (true) {
            st = new StringTokenizer(br.readLine(), " ");
            int[][] p = new int[3][2];
            boolean stop = true;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 2; j++) {
                    p[i][j] = Integer.parseInt(st.nextToken());
                    if (p[i][j] != 0) {
                        stop = false;
                    }
                }
            }
            if (stop) {
                break;
            }

            int maxX = p[0][0];
            int minX = p[0][0];
            int maxY = p[0][1];
            int minY = p[0][1];

            for (int i = 0; i < 3; i++) {
                maxX = Math.max(maxX, p[i][0]);
                minX = Math.min(minX, p[i][0]);
                maxY = Math.max(maxY, p[i][1]);
                minY = Math.min(minY, p[i][1]);
            }

            double tot_area =
                p[0][0] * p[1][1] + p[1][0] * p[2][1] + p[2][0] * p[0][1] - p[0][1] * p[1][0]
                - p[1][1] * p[2][0] - p[2][1] * p[0][0];
            tot_area = Math.abs(tot_area) / 2.0;

            int tot = (maxX - minX + 1) * (maxY - minY + 1);
            int extraVert = -1;
            for (int i = 0; i < 3; i++) {

                int dx = Math.abs(p[i][0] - p[(i + 1) % 3][0]);
                int dy = Math.abs(p[i][1] - p[(i + 1) % 3][1]);

                int gcd = 1;
                for (int j = 1; j * j <= dx; j++) {
                    if (dx % j == 0) {
                        if (dy % j == 0 && j > gcd) {
                            gcd = j;
                        }
                        if (dy % (dx / j) == 0 && (dx / j) > gcd) {
                            gcd = (dx / j);
                        }
                    }
                }
                if (dx == 0) {
                    gcd = dy;
                }
                if (dy == 0) {
                    gcd = dx;
                }
                int np = gcd + 1;
                int triNum = ((dx + 1) * (dy + 1) + np) / 2;
                tot -= triNum;
                tot_area += dx * dy / 2.0;
                if (p[i][0] != maxX && p[i][0] != minX &&
                    p[i][1] != maxY && p[i][1] != minY) {
                    extraVert = i;
                }
            }
            double areaLeft = (maxX - minX) * (maxY - minY);
            areaLeft -= tot_area;
            int extra = 0;
            if (areaLeft > 0) {
                for (int i = 0; i < 2; i++) {
                    for (int j = 0; j < 2; j++) {
                        int h, w;
                        if (i == 0) {
                            h = maxY - p[extraVert][1];
                        } else {
                            h = p[extraVert][1] - minY;
                        }
                        if (j == 0) {
                            w = maxX - p[extraVert][0];
                        } else {
                            w = p[extraVert][0] - minX;
                        }
                        if (w * h == (int) areaLeft) {
                            extra = w * h;
                        }
                    }
                }
            }
            sb.append(tot - extra + 3).append("\n");
        }
        System.out.println(sb);
    }
}
