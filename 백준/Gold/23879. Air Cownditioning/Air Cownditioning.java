import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] p = new int[n];
        int[] t = new int[n];
        int[] c = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++){
            p[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++){
            t[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < n; i++){
            c[i] = p[i] - t[i];
        }
        int[] d = new int[n+1];
        d[0] = c[0];
        for(int i = 1; i <n; i++ ){
            d[i] = c[i]-c[i-1];
        }
        d[n] = -c[n-1];
        int answer = 0;
        for(int i = 0; i < n+1;i++){
            if(d[i]>0) {
                answer += d[i];
            }
        }
        System.out.println(answer);
    }
}
