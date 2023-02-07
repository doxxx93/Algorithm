import java.io.*;
import java.util.*;

class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        for (int test_case = 1; test_case <= T; test_case++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            int c1 = Integer.parseInt(st.nextToken());
            int c2 = Integer.parseInt(st.nextToken());
            List<Integer> cows = new ArrayList<>();
            List<Integer> horses = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                cows.add(Integer.parseInt(st.nextToken()));
            }
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < m; i++) {
                horses.add(Integer.parseInt(st.nextToken()));
            }

            Collections.sort(cows);
            Collections.sort(horses);
            // find min distance binary search

            int min = Integer.MAX_VALUE;
            int count = 0;

            for (int cow : cows) {
                int left = 0;
                int right = horses.size() - 1;
                while (left <= right) {
                    int mid = (left + right) / 2;
                    int horse = horses.get(mid);
                    int distance = Math.abs(cow - horse);
                    if (distance < min) {
                        min = distance;
                        count = 1;
                    } else if (distance == min) {
                        count++;
                    }
                    if (horse < cow) {
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                }
            }


            sb.append("#").append(test_case).append(" ").append(min + Math.abs(c1 - c2)).append(" ")
                .append(count)
                .append("\n");
        }
        System.out.println(sb);
    }
}