import java.util.*;
import java.io.*;

class Main{
    
    public static void main(String[] z)throws IOException{
        var br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] parent = new int[n+1];
        ArrayList<Integer>[] adj = new ArrayList[n+1];
        boolean[] visited = new boolean[n+1];
        
        for(int i = 1; i <= n; i++){
            adj[i] = new ArrayList<>();
        }
        
        StringTokenizer st;
        for (int i = 1; i<n; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adj[a].add(b);
            adj[b].add(a);
        }
        
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        visited[1] = true;
        while(!q.isEmpty()){
            int cur = q.poll();
            for( int x : adj[cur]){
                if(visited[x]){
                    continue;
                }
                visited[x] = true;
                q.add(x);
                parent[x] = cur;
            }
        }
        
        for(int i = 2; i <=n; i++){
            System.out.println(parent[i]);
        }
    }
}