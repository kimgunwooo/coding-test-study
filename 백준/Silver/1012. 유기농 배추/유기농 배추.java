import java.io.*;
import java.util.*;

public class Main {
    static boolean[][] visited;
    static int[][] ground;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {1,-1,0,0};

    static int m, n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        for(int i=0;i<t;i++){
            st = new StringTokenizer(br.readLine(), " ");
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            init(k);

            for(int j=0;j<k;j++){
                st = new StringTokenizer(br.readLine(), " ");
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                ground[y][x] = 1;
            }

            int count=0;
            for(int j=0;j<n;j++){
                for(int l=0;l<m;l++){
                    if(ground[j][l]==1 && !visited[j][l]){
                        count++;
                        dfs(j,l);
                    }
                }
            }
            System.out.println(count);
        }


    }
    private static void init(int k) {
        ground = new int[n][m];
        visited = new boolean[n][m];
    }
    private static void dfs(int x, int y) {
        visited[x][y] = true;

        for(int i=0;i<4;i++){
            int mx = x + dx[i];
            int my = y + dy[i];

            if(mx<n && mx>=0 && my<m && my>=0 && !visited[mx][my] && ground[mx][my]==1)
                dfs(mx,my);
        }

    }
}