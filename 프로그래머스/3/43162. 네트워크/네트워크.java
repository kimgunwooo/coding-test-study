/*
[[1, 1, 0], 
[1, 1, 0], 
[0, 0, 1]]
*/

class Solution {
    boolean[] visited;
    int count;
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        visited = new boolean[n];
        
        for (int i=0; i<n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                answer++;
                dfs(i, computers, n);
            }
        }
        
        
        return answer;
    }
    
    public void dfs(int node, int[][] computers, int n) {
        
        for (int i=0; i<n; i++) {
            if (i == node) continue; // 자기자신 연결 제외
            
            // 연결되어 있으면서, 방문하지 않았다면
            if (computers[node][i] == 1 && !visited[i]) {
                visited[i] = true;
                dfs(i, computers, n);
            }
        }
    }
}