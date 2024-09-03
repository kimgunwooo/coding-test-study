class Solution {
    static int[] answer;
    public int[] solution(int[][] arr) {
        answer = new int[2]; // 0, 1
        
        dfs(arr, 0, 0, arr.length);
        
        return answer;
    }
    
    public void dfs(int[][] arr, int x, int y, int length) {
        if (zipCheck(arr, x, y, length, arr[x][y])) { // 압축 가능 여/부
            if (arr[x][y] == 0) {
                answer[0]++;
            } else {
                answer[1]++;
            }
            return;
        }
        
        
        // quard
        dfs(arr, x, y, length/2);
        dfs(arr, x, y + length/2, length/2);
        dfs(arr, x + length/2, y, length/2);
        dfs(arr, x + length/2, y + length/2, length/2);
    }
    
    public boolean zipCheck(int[][] arr, int x, int y, int length, int num) {
        for (int i=x; i<x + length; i++) {
            for (int j=y; j<y + length; j++) {
                if (arr[i][j] != num) {
                    return false;
                }
            }
        }
        return true;
    }
}