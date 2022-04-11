import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        
        int count = 0;

        for(int i=0;i<N;i++){
            arr[i] = sc.nextInt();
            
        }
        for(int i = 0;i<N;i++){
            count += isPrime(arr[i]);
        }
        System.out.println(count);
    }
    
    public static int isPrime(int n) {
        if(n==1) return 0;
        for (int i = 2; i<=(int)Math.sqrt(n); i++) {
            if (n % i == 0) {
                return 0;
            }
        }
	    return 1;
}
}