/*
최소 필요 피로도 - 각 던전마다 탐험을 시작하기 위해 필요
소모 피로도 - 던전 탐험을 마쳤을 때 소모됨

일일 던전이 여러개 존재 - 최대한 많이 탐험하려 함.
1 <= k : 현재 피로도 <= 5000, dungeons[][] = ["최소 필요 피로도", "소모 피로도"]

[[80,20],
[50,40],
[30,10]]
*/
 

class Solution {
    static boolean[] visited;
    static int count = Integer.MIN_VALUE;
    
    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        dfs(0, k, dungeons);
        return count;
    }
    
    public static void dfs(int v, int k, int[][] dungeons) {
        count = Math.max(count, v);
        
        for (int i=0; i<dungeons.length; i++) {
            if (!visited[i] && dungeons[i][0] <= k) {
                visited[i] = true;
                k -= dungeons[i][1];
                dfs(v+1, k, dungeons);
                // 백트래킹
                visited[i] = false;
                k += dungeons[i][1];
            }
        }
    }
}