import java.util.*;

/*
1번 마을에서 부터 시작.
N개의 마을이 존재. K 시간 이하로 배달이 가능한 마을의 개수를 return
노드 개수는 50이하, 간선의 개수는 2000 이하
가중치 그래프
다익스트라 알고리즘을 통해 1번 노드에서부터 최단거리 테이블을 작성하고, 해당 값이 K 이하인 경우만 골라서 출력
*/

class Solution {
    public class Node {
        int v;
        int cost;
        
        public Node (int v, int cost) {
            this.v = v;
            this.cost = cost;
        }
    }
    
    public int solution(int N, int[][] road, int K) {
        List<Node>[] graph = new ArrayList[N + 1];
        int answer = 0;
        
        for (int i=1; i<=N; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int[] path : road) {
            int from = path[0];
            int to = path[1];
            int cost = path[2];
            
            graph[from].add(new Node(to, cost));
            graph[to].add(new Node(from, cost));
        }
        
        int[] dist = dijkstra(N, 1, graph);
        
        int count = 0;
        for (int d : dist) {
            if (d <= K) count++;
        }
        
        return count;
    }
    
    public int[] dijkstra(int N, int start, List<Node>[] graph) {
        PriorityQueue<Node> queue = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost); // 오름차순
        int[] dist = new int[N+1];
        boolean[] visited = new boolean[N+1];
        
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0; // 시작값 초기화
        queue.offer(new Node(start, dist[start]));
        
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            visited[cur.v] = true;
            
            for (Node next : graph[cur.v]) {
                if (!visited[next.v] && dist[next.v] > cur.cost + next.cost) {
                    dist[next.v] = cur.cost + next.cost;
                    queue.offer(new Node(next.v, dist[next.v]));
                }
            }
        }
        
        return dist;
    }
}