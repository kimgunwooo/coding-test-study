import java.util.*;

class Solution {
    public static int idx = 0;
    
    public int[][] solution(int n) {
        int[][] answer = new int[(int)Math.pow(2,n)-1][2];
        dfs(answer, n, 1, 2, 3);
        
        return answer;
    }
    
    public void dfs(int[][] answer, int n, int from, int mid, int to) {
        if (n == 1) {
            answer[idx++] = new int[]{from, to};
            return;
        }
        
        dfs(answer, n-1, from, to, mid);
        answer[idx++] = new int[]{from, to};
        dfs(answer, n-1, mid, from, to);
    }
}