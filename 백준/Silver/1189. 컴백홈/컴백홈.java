import java.io.*;
import java.util.*;

/**
 * 시간 제한 2초
 * 메모리 제한 128 MB
 * ---
 * R(1 ≤ R ≤ 5),
 * C(1 ≤ C ≤ 5),
 * K(1 ≤ K ≤ R×C)
 */

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    public static int R, C, K;
    public static char[][] map;
    public static boolean[][] visited;
    public static int[] dx = {1, -1, 0, 0};
    public static int[] dy = {0, 0, 1, -1};
    public static int count = 0;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        visited = new boolean[R][C];
        for (int i=0; i<R; i++) {
            String str = br.readLine();
            for (int j=0; j<C; j++) {
                map[i][j] = str.charAt(j);
            }
        }

        dfs(R-1, 0, 1);
        System.out.println(count);
    }

    private static void dfs(int x, int y, int depth) {
        if (depth == K && x == 0 && y == C-1) {
            count++;
        }

        visited[x][y] = true;

        for (int i=0; i<4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || ny < 0 || nx >= R || ny >= C || visited[nx][ny] || map[nx][ny] == 'T')
                continue;
            dfs(nx, ny, depth+1);
            visited[nx][ny] = false;
        }
    }
}