import java.util.*;

class Solution {
    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, 1, -1};
    
    public int solution(int[][] maps) {
        int answer = bfs(0, 0, maps);
        
        return answer;
    }
    
    public int bfs(int x, int y, int[][] maps) {
        Queue<int[]> q = new LinkedList<>();
        int n = maps.length;
        int m = maps[0].length;
        boolean[][] visited = new boolean[n][m];
        int min = 999_999;
        boolean flag = false;
        
        q.offer(new int[]{x,y,1});
        visited[x][y] = true;
        
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int cx = cur[0];
            int cy = cur[1];
            int cnt = cur[2];
            
            for (int i=0; i<4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                
                if (nx < 0 || ny < 0 || nx >= n || ny >= m || visited[nx][ny]) continue;
                
                if (maps[nx][ny] == 1) {
                    q.offer(new int[]{nx, ny, cnt+1});
                    visited[nx][ny] = true;
                    
                    if (nx == n-1 && ny == m-1) {
                        flag = true;
                        min = Math.min(min, cnt+1);
                    }
                }
            }
        }
        
        return flag ? min : -1;
    }
}