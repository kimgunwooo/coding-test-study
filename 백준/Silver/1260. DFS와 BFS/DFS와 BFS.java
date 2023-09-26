import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] graph = new int[1001][1001];
    static boolean[] visited = new boolean[1001];
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken()); //정점
        int m = Integer.parseInt(st.nextToken()); //간선
        int v = Integer.parseInt(st.nextToken()); //시작정점

        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine()," ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            init(a,b);
        }

        dfs(v);
        System.out.println();
        bfs(v);
    }
    static void init(int a, int b){
        graph[a][b] = graph[b][a] = 1;
    }
    static void dfs(int node){
        visited[node] = true;
        System.out.print(node + " ");

        for(int i=1;i<=n;i++){
            if(!visited[i] && graph[node][i] == 1){
                dfs(i);
            }
        }
    }
    static void bfs(int node){
        visited = new boolean[1001];
        Queue<Integer> queue = new LinkedList<>();
        visited[node] = true;
        queue.add(node);

        while(!queue.isEmpty()){
            int v = queue.remove();
            System.out.print(v + " ");

            for(int i=1;i<=n;i++){
                if(!visited[i] && graph[v][i] == 1){
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
    }
}