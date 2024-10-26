import java.util.*;

/*
n 은 최대 100
완전탐색 가능. 
그래프에서 모든 정점에 대해서 끊는 작업을 진행 후, bfs 로 탐색하면서 덩어리별 송전탑 개수 카운팅.
중복해서 끊는 경우가 생길 수 있음. visited 배열을 통해 중복체크.
*/

class Solution {
    
    public int solution(int n, int[][] wires) {
        int result = 10_001;
        
        int[][] tree = new int[n+1][n+1];
        
        // init tree
        for (int i=0; i<n-1; i++) {
            int v1 = wires[i][0];
            int v2 = wires[i][1];
            tree[v1][v2] = 1;
            tree[v2][v1] = 1;
        }
        
        for (int i=0; i<n-1; i++) { // 모든 전선을 끊어보면서 bfs 탐색 진행
            int v1 = wires[i][0];
            int v2 = wires[i][1];
            
            // 전선 끊기
            tree[v1][v2] = 0;
            tree[v2][v1] = 0;
            
            int count = this.bfs(n, v1, tree);
            result = Math.min(result, count);
            
            // 전선 복구
            tree[v1][v2] = 1;
            tree[v2][v1] = 1;
        }
        
        return result;
    }
    
    public int bfs(int n, int start, int[][] tree) {
        boolean[] visited = new boolean[n+1];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        int count = 1;
        
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            visited[cur] = true;
            
            for (int i=1; i<=n; i++) {
                if (!visited[i] && tree[cur][i] == 1) {
                    queue.offer(i);
                    count++;
                }
            }
        }
        
        return Math.abs((n - count) - count); // 송진탑 개수의 차이 (절대값)
    }
}