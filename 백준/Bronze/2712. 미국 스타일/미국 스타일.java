import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] z) throws IOException{
        var br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        StringTokenizer st;
        while(n-->0){
            st = new StringTokenizer(br.readLine());
            Double a = Double.parseDouble(st.nextToken());
            String tp = st.nextToken();
            if(tp.equals("kg")){
                System.out.printf("%.04f lb\n", a * 2.2046);
            } else if(tp.equals("g")){
                System.out.printf("%.04f l\n", a * 3.7854);
            } else if(tp.equals("l")){
                System.out.printf("%.04f g\n", a * 0.2642);
            } else if (tp.equals("lb")){
                System.out.printf("%.04f kg\n", a * 0.4536);
            } 
        }
    }
}