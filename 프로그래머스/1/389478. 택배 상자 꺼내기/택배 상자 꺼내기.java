/*
즉, 찾으려는 상자의 깊이를 찾는 문제
*/

class Solution {
    public static int[][] map = new int[101][101];
    public static char[] command = {'r', 'l'};
    
    public int solution(int n, int w, int num) {
        int answer = 0;
        
        int targetX = 0;
        int targetY = 0;
        int x = 1;
        int y = 100;
        int flag = 0;
        for (int i=1; i<=n; i++) {
            map[y][x] = i;
            
            if (i == num) {
                targetX = x;
                targetY = y;
            }
            
            if (command[flag] == 'r' && x == w) {
                y--;
                flag = 1;
            } else if (command[flag] == 'l' && x == 1) {
                y--;
                flag = 0;
            } else {
                if (flag == 0) {
                    x++;
                } else {
                    x--;
                }
            }
        }
        
        while (map[targetY][targetX] != 0) {
            answer++;
            targetY--;
        }
        
        // for (int i=1; i<101; i++) {
        //     for (int j=1; j<101; j++) {
        //         System.out.print(map[i][j] + " ");
        //     }
        //     System.out.println();
        // }
        
        return answer;
    }
}