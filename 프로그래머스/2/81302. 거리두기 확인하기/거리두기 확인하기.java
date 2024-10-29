/*
5x5 고정 배열 5개 주어짐.
P(사용자) 기준으로 상하좌우 탐색. O를 만난다면 한번더 탐색, X를 만난다면 중단
탐색 중 시작 P가 아닌 P를 만나게 된다면 거리두기를 지키지 않는 것으로 판단
*/


class Solution {
    public static boolean[][] visited;
    public static int check;
    
    public int[] solution(String[][] places) {
        int[] result = new int[5];
        
        for (int i=0; i<5; i++) {
            visited = new boolean[5][5];
            check = 1;
            for (int j=0; j<5; j++) {
                for (int k=0; k<5; k++) {
                    if (check == 0) continue;
                    
                    if (places[i][j].charAt(k) == 'P') {
                        visited[j][k] = true;
                        dfs(places, i, j, k, 0);
                    }
                }
            }
            result[i] = check;
        }
        
        return result;
    }
    
    public void dfs(String[][] places, int i, int j, int k, int depth) {
        if (j < 0 || k < 0 || j >= 5 || k >= 5) {
            return;
        }
        
        if (places[i][j].charAt(k) == 'X' || depth >= 3) {
            return;
        }
        
        if (!visited[j][k] && places[i][j].charAt(k) == 'P') {
            System.out.println("걸림 i = "+i+j+k);
            check = 0;
            return;
        }
        
        dfs(places, i, j+1, k, depth+1);
        dfs(places, i, j, k+1, depth+1);
        dfs(places, i, j-1, k, depth+1);
        dfs(places, i, j, k-1, depth+1);
    }
}