import java.io. *;
import java.util. *;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());

        int[] heights = new int[w];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < w; i++) {
            heights[i] = Integer.parseInt(st.nextToken());
        }

        int[] prefix = new int[w];
        int[] suffix = new int[w];
        prefix[0] = heights[0];
        suffix[w - 1] = heights[w - 1];
        for (int i = 1; i < w; i++) {
            prefix[i] = Math.max(prefix[i - 1], heights[i]);
            suffix[w - i - 1] = Math.max(suffix[w - i], heights[w - i - 1]);
        }

        int total = 0;
        for (int i = 0; i < w; i++) {
            total += Math.min(prefix[i], suffix[i]) - heights[i];
        }
        System.out.println(total);
    }
}