import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static LinkedList<Integer>[] graph;
    static boolean[] visited;
    static int[] parents;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        //초기화
        graph = new LinkedList[n+1];
        visited = new boolean[n+1];
        parents = new int[n+1];
        for(int i=0;i<=n;i++){
            graph[i] = new LinkedList<>();
        }

        for(int i=0;i<n-1;i++){
            st = new StringTokenizer(br.readLine()," ");
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            init(v1,v2);
        }

        for(int i=1;i<=n;i++){
            Collections.sort(graph[i]);
        }

        dfs(1);

        for(int i=2;i<parents.length;i++){
            System.out.println(parents[i]);
        }
    }
    private static void init(int v1, int v2) {
        graph[v1].add(v2);
        graph[v2].add(v1);
    }
    private static void dfs(int node) {
        visited[node] = true;

        for (int v : graph[node]) {
            if (!visited[v]){
                parents[v] = node;
                dfs(v);
            }
        }
    }
}