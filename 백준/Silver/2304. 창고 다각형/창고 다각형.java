import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<Pillar> al = new ArrayList<>();
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            al.add(new Pillar(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        Collections.sort(al);

        int answer = 0;
        int max = 0;
        Pillar current = al.get(0);
        for (int i = 1; i < n; i++) {
            if (current.h <= al.get(i).h) {
                answer += (al.get(i).l - current.l) * current.h;
                current = al.get(i);
                max = i;
            }
        }
        current = al.get(al.size() - 1);
        for (int i = 0; i < n - max; i++) {
            if (current.h <= al.get(n-1-i).h) {
                answer += (current.l - al.get(n-1-i).l) * current.h;
                current = al.get(n-1-i);
            }
        }
        answer += current.h;
        System.out.println(answer);
    }

    static class Pillar implements Comparable<Pillar> {

        int l;
        int h;

        public Pillar(int l, int h) {
            this.l = l;
            this.h = h;
        }

        @Override
        public int compareTo(Pillar o) {
            return this.l - o.l;
        }
    }
}