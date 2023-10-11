import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static List<List<Integer>> graph;
    static boolean[] visited;
    static int k;
    static int[] dis;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken()); //정점 수
        int m = Integer.parseInt(st.nextToken()); //간선 수
        k = Integer.parseInt(st.nextToken()); //최단거리
        int x = Integer.parseInt(st.nextToken()); //출발 도시 번호

        graph = new ArrayList<>();
        for(int i=0;i<n+1;i++){
            graph.add(new ArrayList<>());
        }
        visited = new boolean[n+1];
        dis = new int[n+1];

        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine()," ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            graph.get(from).add(to);
        }

        bfs(x);

        for(int i=1;i<dis.length;i++){
            if(dis[i] == k){
                sb.append(i).append("\n");
            }
        }
        if(sb.length()==0){
            System.out.println(-1);
        }
        System.out.println(sb);
    }
    private static void bfs(int start) {
        visited[start] = true;
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(start);

        dis[start] = 0;

        while(!queue.isEmpty()){
            int c = queue.remove();
            for(int i : graph.get(c)){
                if(!visited[i]){
                    visited[i] = true;
                    queue.add(i);
                    dis[i] = dis[c] + 1;
                }
            }
        }
    }
}