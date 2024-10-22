/*
1
2 6
3 4 5
4
5
...
n, n+1, n+2, ... n+(n-1)

3 -> 6
4 -> 10
5 -> 15
6 -> 21

n*(n+1) /2
*/

class Solution {
    
    public static int[][] metrix;
    
    public int[] solution(int n) {
        metrix = new int[n][n];
        
        int length = n*(n+1)/2;
        this.initMetrix(length, n);
        
        return this.createResponse(length, n);
    }
    
    public void initMetrix(int length, int n) {
        int x = 0;
        int y = 0;
        metrix[y][x] = 1;
        String command = "down"; // down, right, upLeft
        
        for (int i=2; i<=length; i++) {
            if (command.equals("down")) {
                y++;
                if (y+1 >= n || metrix[y+1][x] != 0) command = "right";
            } else if (command.equals("right")) {
                x++;
                if (x+1 >= n || metrix[y][x+1] != 0) command = "upLeft";
            } else if (command.equals("upLeft")) {
                x--;
                y--;
                if (metrix[y-1][x-1] != 0) command = "down";
            }
            
            metrix[y][x] = i;
        }
    }
    
    public int[] createResponse(int length, int n) {
        int[] answer = new int[length];
        int num = 0;
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                if (metrix[i][j] != 0) {
                    answer[num] = metrix[i][j];
                    num++;
                }
            }
        }
        return answer;
    }
}