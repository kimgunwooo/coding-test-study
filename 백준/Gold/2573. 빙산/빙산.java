import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] ground;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {1,-1,0,0};
    static int n;
    static int m;
    static boolean[][] visited;
    static int[][] melt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        n = Integer.parseInt(st.nextToken()); //5
        m = Integer.parseInt(st.nextToken()); //7
        ground = new int[n][m];
        melt = new int[n][m];
        //빙산 구성
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0;j<m;j++){
                ground[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int count = 0;
        while(true){
            //두 덩어리 이상으로 분리되는지 체크
            int num = countIceberg();
            if(num == 0 ){ //끝까지 나누어지지 않으면
                count = 0;
                break;
            }
            else if(num >= 2) { //2덩어리 이상으로 나누어지면
                break;
            }
            //녹이기
            Melt();
            count++;
        }
        System.out.println(count);
    }
    private static int countIceberg() {
        visited = new boolean[n][m];
        int count = 0;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(!visited[i][j] && ground[i][j] != 0){
                    dfs(i,j); //총 몇 개의 빙하로 나누어 졌는지 알 수 있다.
                    count++;
                }
            }
        }

        return count;
    }
    private static void dfs(int x, int y){
        visited[x][y] = true;

        for(int i=0;i<4;i++){
            int mx = x + dx[i];
            int my = y + dy[i];

            if(mx>=0 && my>=0 && mx<n && my<m){
                if(ground[mx][my] == 0) //주변이 바다라면 melt배열에 개수 저장
                    melt[x][y]++;

                if(ground[mx][my] != 0 && !visited[mx][my]) //값이 있고, 방문하지 않았으면 계속 탐색
                    dfs(mx, my);
            }
        }
    }
    private static void Melt() {
        for(int i=0;i<n;i++) {
            for (int j = 0; j < m; j++) {
                ground[i][j] -= melt[i][j]; //각 빙산마다 주변의 바다의 수를 뺌
                if (ground[i][j] < 0) //음수 처리
                    ground[i][j] = 0;
                melt[i][j] = 0; //초기화
            }
        }
    }
}