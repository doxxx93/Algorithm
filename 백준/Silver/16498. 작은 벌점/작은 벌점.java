import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        List<Integer>[] list = new ArrayList[3];
        for (int i = 0; i < 3; i++) {
            list[i] = new ArrayList<>();
            Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt)
                .forEach(list[i]::add);
            Collections.sort(list[i]);
        }
        int answer = Integer.MAX_VALUE;
        for (int x : list[0]) {
            for (int y : list[1]) {
                //upperbound min (x,y) in list[2]
                int index = Collections.binarySearch(list[2], Math.min(x, y));
                
                if (index < 0) {
                    index = -index - 1;
                }
                if (index < list[2].size()) {
                    answer = Math.min(answer,
                        Math.max(x, Math.max(y, list[2].get(index))) - Math.min(x,
                            Math.min(y, list[2].get(index))));
                }
                if (index > 0) {
                    answer = Math.min(answer,
                        Math.max(x, Math.max(y, list[2].get(index - 1))) - Math.min(x,
                            Math.min(y, list[2].get(index - 1))));
                }
            }
        }

        System.out.println(answer);
    }
}