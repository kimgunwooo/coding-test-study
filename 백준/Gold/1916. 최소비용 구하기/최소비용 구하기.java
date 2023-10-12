import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Node implements Comparable<Node>{
    int idx;
    int weight;

    public Node(int to, int weight) {
        this.idx = to;
        this.weight = weight;
    }

    @Override
    public int compareTo(Node o) {
        return this.weight - o.weight;
    }
}

public class Main {
    static List<List<Node>> graph;
    static int[] dist;
    static boolean[] check;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        graph = new ArrayList<>();
        for(int i=0;i<=n;i++){
            graph.add(new ArrayList<>());
        }
        dist = new int[n+1];
        check = new boolean[n+1];

        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine()," ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            graph.get(from).add(new Node(to,weight));
        }

        st = new StringTokenizer(br.readLine()," ");
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        bfs(start,end);

        System.out.println(dist[end]);

    }

    private static void bfs(int start, int end) {
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(start,0));

        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[start] = 0;

        while(!queue.isEmpty()){
            int curIdx = queue.remove().idx;

            if(check[curIdx]) continue;
            check[curIdx] = true;

            for(Node next : graph.get(curIdx)){
                if(!check[next.idx] && dist[next.idx] > dist[curIdx] + next.weight){
                    dist[next.idx] = dist[curIdx] + next.weight;
                    queue.add(new Node(next.idx, dist[next.idx]));
                }
            }
        }
    }
}