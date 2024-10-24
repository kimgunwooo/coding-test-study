import java.util.*;
/*
최대 100x100 배열
dfs 로의 depth가 깊어도 100이기에 할만하다.

*/

class Solution {
    public static int n;
    public static int m;
    public static int sum;
    public static boolean[][] visited;
    
    public int[] solution(String[] maps) {
        List<Integer> temp = new ArrayList<>();
        n = maps.length;
        m = maps[0].length();
        
        int[][] intMap = new int[n][m];
        visited = new boolean[n][m];
        
        for(int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                char c = maps[i].charAt(j);
                if (c == 'X') {
                    intMap[i][j] = 0;
                    visited[i][j] = true; // 바다는 미리 방문 처리
                } else {
                    intMap[i][j] = (int) c - 48;
                }
            }
        }
        
        for(int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (!visited[i][j]) {
                    sum = 0;
                    this.dfs(intMap, i, j);
                    temp.add(sum);
                }
            }
        }
        
        Collections.sort(temp);
        
        if (temp.size() == 0) {
            return new int[]{-1};
        } else {
            int[] result = new int[temp.size()];
            for (int i=0; i<result.length; i++) {
                result[i] = temp.get(i);
            }
            return result;
        }
    }
    
    public void dfs(int[][] intMap, int i, int j) {
        if(i < 0 || j < 0 || i >= n || j >= m)
            return;
        
        if(visited[i][j])
            return;
        
        sum += intMap[i][j];
        visited[i][j] = true;
        
        dfs(intMap, i, j+1);
        dfs(intMap, i, j-1);
        dfs(intMap, i+1, j);
        dfs(intMap, i-1, j);
    }
}