import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] map;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {1,-1,0,0};
    static boolean[][] visited;
    static int n,m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n+1][m+1];
        visited = new boolean[n+1][m+1];

        for(int i=1;i<=n;i++){
            String str = br.readLine();
            for(int j=1;j<=m;j++){
                map[i][j] = Integer.parseInt(String.valueOf(str.charAt(j-1)));
            }
        }

        bfs(1,1);
        System.out.println(map[n][m]);
    }

    private static void bfs(int x, int y) {
       Queue<int[]> queue = new ArrayDeque<>();
       queue.add(new int[] {x,y});
       visited[x][y] = true;

       while(!queue.isEmpty()) {
           int[] q = queue.remove();
           int nx = q[0];
           int ny = q[1];

           for (int i = 0; i < 4; i++) {
               int mx = nx + dx[i];
               int my = ny + dy[i];

               if (mx > 0 && my > 0 && mx <= n && my <= m) {
                   if (!visited[mx][my] && map[mx][my] != 0) {
                       queue.add(new int[]{mx, my});
                       visited[mx][my] = true;
                       map[mx][my] = map[nx][ny] + 1;
                   }
               }
           }
       }
    }
}