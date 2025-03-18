import java.util.*;
/*
간선의 개수만 판단.
*/

class Solution {
    public static List<List<Integer>> graph = new ArrayList<>();
    public static boolean[] visited;
    public static int[] path;
    
    public int solution(int n, int[][] edge) {
        int answer = 0;
        
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        visited = new boolean[n+1];
        path = new int[n+1];
        
        for (int[] e : edge) {
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }
        
        // Arrays.fill(path, 999_999);
        bfs(1);
        
        int max = -1;
        for (int p : path) {
            // System.out.print(p + " ");
            max = Math.max(max, p);
        }
        
        for (int p : path) {
            if (max == p) answer++;
        }
        
        return answer;
    }
    
    public void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        
        queue.offer(start);
        visited[start] = true;
        path[start] = 0;
        
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            
            for (int next : graph.get(cur)) {
                if (visited[next]) continue;
                visited[next] = true;
                queue.offer(next);
                path[next] = path[cur] + 1;
            }
        }
    }
}