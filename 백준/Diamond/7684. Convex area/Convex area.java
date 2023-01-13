import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) {
                break;
            }
            int[][] pts = new int[n][3];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 3; j++) {
                    pts[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            double r = 0;
            for (int a = 0; a < n; a++) {
                for (int b = a + 1; b < n; b++) {
                    for (int c = b + 1; c < n; c++) {
                        int neg = 0;
                        int pos = 0;
                        int zero = 0;
                        int[][] mat = new int[3][];
                        mat[0] = sub(pts[b], pts[a]);
                        mat[1] = sub(pts[c], pts[a]);
                        if (mat[0][0] * mat[1][1] == mat[0][1] * mat[1][0] &&
                            mat[0][0] * mat[1][2] == mat[0][2] * mat[1][0] &&
                            mat[0][1] * mat[1][2] == mat[0][2] * mat[1][1]) {
                            continue;
                        }
                        for (int[] d : pts) {
                            mat[2] = sub(d, pts[a]);
                            long dd = det(mat);
                            if (dd < 0) {
                                neg++;
                            } else if (dd > 0) {
                                pos++;
                            } else {
                                zero++;
                            }
                        }
                        if (neg == 0 || pos == 0) { // face
                            if (zero != 3) {
                                throw new Exception("Points on face is " + zero);
                            }
                            r += area(dist(mat[0]), dist(mat[1]),
                                dist(sub(pts[b], pts[c])));
                        }
                    }
                }
            }
            System.out.println(Math.round(r));
        }
    }

    static long det(int[][] m) {
        return m[0][0] * (m[1][1] * (long) m[2][2] - m[1][2] * (long) m[2][1]) +
               m[0][1] * (m[1][2] * (long) m[2][0] - m[1][0] * (long) m[2][2]) +
               m[0][2] * (m[1][0] * (long) m[2][1] - m[1][1] * (long) m[2][0]);
    }

    static int[] sub(int[] a, int[] b) {
        int[] r = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            r[i] = a[i] - b[i];
        }
        return r;
    }

    static double dist(int[] v) {
        double r = 0;
        for (int a : v) {
            r += a * (double) a;
        }
        return Math.sqrt(r);
    }

    static double area(double a, double b, double c) {
        double s = (a + b + c) / 2;
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }
}
