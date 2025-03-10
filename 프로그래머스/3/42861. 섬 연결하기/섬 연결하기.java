import java.util.*;

/*
무방향 그래프에서 최소 신장 트리 구하기

모든 정점에서부터 시작해서 사이클이 생기기 전까지 탐색해서 최소 경로를 구하기
*/

class Node implements Comparable<Node> {
    int node;
    int cost;
    public Node (int node, int cost) {
        this.node = node;
        this.cost = cost;
    }
    public int compareTo(Node o) {
        return this.cost - o.cost;
    }
}

class Solution {
    public static List<List<Node>> graph;
    
    public int solution(int n, int[][] costs) {
        graph = new ArrayList<>();
        for (int i=0; i<=n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int[] c : costs) {
            int start = c[0];
            int end = c[1];
            int cost = c[2];
            graph.get(start).add(new Node(end,cost));
            graph.get(end).add(new Node(start,cost));
        }
        
        PriorityQueue<Node> pq = new PriorityQueue<>();
        boolean[] visited = new boolean[n+1];
        
        // 그래프 탐색. MST를 구하는 것이기에 아무 정점에서나 시작해서 탐색.
        // cost 기반 오름차순으로 정렬해서 작은거 순으로 선택
        for (Node o : graph.get(0)) {
            pq.offer(o);
            // System.out.println(o.cost);
        }
        visited[0] = true;
        
        int min = 0;
        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            
            if (visited[cur.node]) continue;
            
            for (Node next : graph.get(cur.node)) {
                pq.offer(next);
            }
            min += cur.cost;
            visited[cur.node] = true;
        }
        
        
        return min;
    }
}