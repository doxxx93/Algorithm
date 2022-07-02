import java.io.*;
import java.util.*;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int t;
    static int n;
    static int[] a;
    static List<Integer> listA = new ArrayList<>();
    static List<Integer> listB = new ArrayList<>();
    static int m;
    static int[] b;


    public static void main(String[] args) throws IOException {
        input();
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += a[j];
                listA.add(sum);
            }
        }
        for (int i = 0; i < m; i++) {
            int sum = 0;
            for (int j = i; j < m; j++) {
                sum += b[j];
                listB.add(sum);
            }
        }
        Collections.sort(listA);
        Collections.sort(listB);

        System.out.println(getCount());

    }

    private static long getCount() {
        int pa = 0;
        int pb = listB.size() - 1;
        long cnt = 0;

        while (pa < listA.size() && pb >= 0) {
            long sum = listA.get(pa) + listB.get(pb);

            if (sum == t) {
                int a = listA.get(pa);
                int b = listB.get(pb);
                long acount = 0;
                long bcount = 0;

                while (pa < listA.size() && listA.get(pa) == a) {
                    acount++;
                    pa++;
                }
                while (pb >= 0 && listB.get(pb) == b) {
                    bcount++;
                    pb--;
                }

                cnt += acount * bcount;
            } else if (sum < t) {
                pa++;
            } else {
                pb--;
            }
        }
        return cnt;
    }

    private static void input() throws IOException {
        t = Integer.parseInt(br.readLine());
        n = Integer.parseInt(br.readLine());
        a = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());

        }
        m = Integer.parseInt(br.readLine());
        b = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            b[i] = Integer.parseInt(st.nextToken());
        }
    }
}

