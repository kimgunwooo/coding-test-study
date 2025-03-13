import java.util.*;
/*
기둥
- 바닥 위에 있어야 함. or 보의 한쪽 끝 부분 위에 있어야 함. or 다른 기둥 위에 있어야 함.

보
- 한쪽 끝 부분이 기둥 위 or 양쪽 끝 부분이 다른 보와 동시에 연결

기둥, 보 설치 어떻게 그릴래?
매번 기둥, 보를 설치할때마다 해당 좌표가 맞는지 검사를 해야함.
그렇기에 인덱스로 접근할 수 있는 배열에 저장?
    그럼 보와 기둥이 겹치는 부분은 어떻게 계산? 기둥=1 보=2 로 계산하기.
       3  4  4  3 
    3  3        2
    1           1
    
    3  4  4  4  3
    1           1
    
    보를 세울 때
        1=기둥
        2=한쪽이 보
        3=기둥에 보
        4=보보
        5=보기둥보
        
    없앨 때
*/

class Solution {
    public static boolean[][] pillar;
    public static boolean[][] bo;
    public static int count;
    
    public int[][] solution(int n, int[][] build_frame) {
        pillar = new boolean[n+1][n+1];
        bo = new boolean[n+1][n+1];
        
        for (int[] build : build_frame) {
            int x = build[0];
            int y = build[1];
            int a = build[2]; // 0=기둥, 1=보
            int b = build[3]; // 0=삭제, 1=설치
            
            if (a == 0) { // 기둥 일 때
                if (b==1 && canBuildPillar(y, x)) { // 생성요청이고, 생성 가능하다면
                    pillar[y][x] = true;
                    count++;
                }
                if (b==0) { // 삭제요청인지
                    pillar[y][x] = false;
                    if (!canBreak(n)) {
                        pillar[y][x] = true; // 삭제하지 못한다면 원상복귀
                    } else {
                        count--;
                    }
                }
            } 
            else if(a == 1) { // 보 일 때
                if (b==1 && canBuildBo(y, x)) {
                    bo[y][x] = true;
                    count++;
                }
                if (b==0) {
                    bo[y][x] = false;
                    if (!canBreak(n)) {
                        bo[y][x] = true;
                    } else {
                        count--;
                    }
                }
            }
        }
        
        int[][] answer = new int[count][3];
        int idx = 0;
        for (int i=0; i<=n; i++) {
            for (int j=0; j<=n; j++) {
                if (pillar[j][i]) {
                    answer[idx][0] = i;
                    answer[idx][1] = j;
                    answer[idx++][2] = 0;
                }
                if (bo[j][i]) {
                    answer[idx][0] = i;
                    answer[idx][1] = j;
                    answer[idx++][2] = 1;
                }
            }
        }
        
        return answer;
    }
    
    public boolean canBreak(int n) {
        for (int i=0; i<=n; i++) {
            for (int j=0; j<=n; j++) {
                if (pillar[i][j] && !canBuildPillar(i,j)) return false;
                if (bo[i][j] && !canBuildBo(i,j)) return false;
            }
        }
        return true;
    }
    
    public boolean canBuildPillar(int y, int x) {
        // 바닥 위, 다른 기둥 위, 보 위(왼쪽, 오른쪽)
        return y==0 || 
            (y>0 && pillar[y-1][x]) || 
            (x>0 && bo[y][x-1]) || 
            bo[y][x];
    }
    
    public boolean canBuildBo(int y, int x) {
        // 기둥 위, 보와 보 사이
        return (y>0 && pillar[y-1][x]) || 
            (y>0 && pillar[y-1][x+1]) ||
            (x>0 && bo[y][x-1] && bo[y][x+1]);
    }
}