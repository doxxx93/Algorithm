import java.io.*;
import java.util.*;

public class Main {

    static class Town implements Comparable<Town> {

        long position;
        long people;

        public Town(long position, long people) {
            this.position = position;
            this.people = people;
        }

        @Override
        public int compareTo(Town o) {
            return Long.compare(this.position, o.position);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        long totalPeople = 0;
        PriorityQueue<Town> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            long position = Long.parseLong(st.nextToken());
            long people = Long.parseLong(st.nextToken());
            totalPeople += people;
            pq.add(new Town(position, people));
        }
        long tempPeople = 0;
        for (int i = 0; i < n; i++) {
            Town town = pq.poll();
            tempPeople += town.people;
            if (tempPeople >= (totalPeople + 1) / 2) {
                System.out.println(town.position);
                return;
            }
        }
    }
}