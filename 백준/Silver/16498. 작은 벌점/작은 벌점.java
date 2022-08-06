import java.io.*;

public class Main {
    static int a, b, c;
    static int[] card_A;
    static int[] card_B;
    static int[] card_C;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int result = Integer.MAX_VALUE;
        String[] st = br.readLine().split(" ");
        a = Integer.parseInt(st[0]);
        b = Integer.parseInt(st[1]);
        c = Integer.parseInt(st[2]);

        card_A = new int[a];
        card_B = new int[b];
        card_C = new int[c];

        for(int i=0;i<3;i++) {
            String[] st2 = br.readLine().split(" ");
            for(int j=0;j<st2.length;j++) {
                if(i==0)
                    card_A[j] = Integer.parseInt(st2[j]);
                if(i==1)
                    card_B[j] = Integer.parseInt(st2[j]);
                if(i==2)
                    card_C[j] = Integer.parseInt(st2[j]);
            }
        }

        for(int i=0;i< a;i++) {
            for(int j=0;j< b;j++) {
                for(int k=0;k< c;k++) {
                    result = Math.min(result,Math.abs(Math.max(Math.max(card_A[i], card_B[j]),card_C[k])- Math.min(Math.min(card_A[i], card_B[j]),card_C[k])));
                }
            }
        }

        bw.write(result + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}