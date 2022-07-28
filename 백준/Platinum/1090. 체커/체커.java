import java.io.*;
import java.util.*;

public class Main {

    static class Pair<x, y>{

        int x;
        int y;
        Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Pair> al = new ArrayList<>();
        Set<Integer> setX = new HashSet<>();
        Set<Integer> setY = new HashSet<>();

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            al.add(new Pair(x, y));
            setX.add(x);
            setY.add(y);
        }
        List<Integer> xList = new ArrayList<>(setX);
        List<Integer> yList = new ArrayList<>(setY);
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.MAX_VALUE;
        }
        StringBuilder sb = new StringBuilder();
        for (Integer x : xList) {
            for (Integer y : yList) {
                List<Integer> dist = new ArrayList<>();
                for (Pair p : al) {
                    dist.add(Math.abs(x - p.x) + Math.abs(y - p.y));
                }
                Collections.sort(dist);
                int sum = 0;
                for (int i = 0; i < dist.size(); i++) {
                    sum += dist.get(i);
                    arr[i] = Math.min(arr[i], sum);
                }
            }
        }
        for (int i : arr) {
            sb.append(i).append(" ");
        }
        System.out.println(sb);
    }
}