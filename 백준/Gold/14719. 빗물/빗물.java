import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int[] height = new int[w];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < w; i++) {
            height[i] = Integer.parseInt(st.nextToken());
        }
        int answer = 0;
        for (int current = 1; current < w - 1; current++) {
            int currentHeight = height[current];
            int lMax = currentHeight;
            int rMax = currentHeight;
            for (int j = current - 1; j >= 0; j--) {
                lMax = Math.max(lMax, height[j]);
            }
            for (int j = current + 1; j < w; j++) {
                rMax = Math.max(rMax, height[j]);
            }
            if (Math.min(lMax, rMax) > currentHeight) {
                answer += Math.min(lMax, rMax) - currentHeight;
            }
        }
        System.out.println(answer);
    }
}