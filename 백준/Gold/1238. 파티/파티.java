import java.io.*;
import java.util.*;

/**
 * 시간 제한 1초
 * 메모리 제한 128 MB
 * ---
 * 다익스트라 알고리즘인데, 가장 많은 시간을 소비하는 학생을 구해야 함.
 * dist 배열을 통해서 최단 시간 배열을 구한 뒤, 그 중에서 최대값 반환하기
 *
 * 처음 생각은 다익스트라 알고리즘을 n번 반복해서 그 중에서 최대값을 구하려고 했다.
 * 하지만, 역방향 그래프를 사용하면 된다.
 * 역방향 그래프 = 간선만 반대방향으로 뒤집은 것
 */

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    public static int N, M, X;
    static ArrayList<Node>[] adj, r_adj;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken()); // 모이는 마을

        adj = new ArrayList[N + 1];
        r_adj = new ArrayList[N + 1];
        for (int i=0; i<=N; i++) {
            adj[i] = new ArrayList<>();
            r_adj[i] = new ArrayList<>();
        }

        for (int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());
            adj[start].add(new Node(end, time));
            r_adj[end].add(new Node(start, time)); // 역방향
        }

        int[] adj_dist = dijkstra(adj);
        int[] r_adj_dist = dijkstra(r_adj);

        int max = 0;
        for (int i=1; i<=N; i++) {
            max = Math.max(adj_dist[i]+r_adj_dist[i], max);
        }

        System.out.println(max);
    }

    private static int[] dijkstra(ArrayList<Node>[] adj) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        int[] dist = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        pq.offer(new Node(X, 0));
        dist[X] = 0;

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            for (Node next : adj[cur.node]) {
                if (dist[next.node] > dist[cur.node] + next.time) {
                    dist[next.node] = dist[cur.node] + next.time;
                    pq.offer(new Node(next.node, dist[next.node]));
                }
            }
        }

        return dist;
    }

    public static class Node implements Comparable<Node>{
        int node;
        int time;
        public Node(int node, int time) {
            this.node = node;
            this.time = time;
        }
        public int compareTo(Node o) {
            return time - o.time;
        }
    }
}