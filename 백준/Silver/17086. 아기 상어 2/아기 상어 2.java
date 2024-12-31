import java.io.*;
import java.util.*;

/**
 * 시간 제한 2초
 * 메모리 제한 512 MB
 * ---
 *
 */

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    public static int N, M;
    public static int[][] space;
    public static boolean[][] visited;
    public static int[] dx = {1, -1, 0, 0, 1, -1, 1, -1};
    public static int[] dy = {0, 0, 1, -1, 1, -1, -1, 1};
    public static int result = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        space = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                space[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (space[i][j] == 1) continue;
                result = Math.max(result, bfs(i,j));
            }
        }

        System.out.println(result);
    }

    private static int bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y, 0});

        visited = new boolean[N][M];
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            for (int i = 0; i < 8; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                int nDistance = cur[2] + 1;

                if (nx < 0 || nx >= N || ny < 0 || ny >= M || visited[nx][ny]) continue;

                if (space[nx][ny] == 1) return nDistance;

                queue.offer(new int[]{nx, ny, nDistance});
                visited[nx][ny] = true;
            }
        }
        return 0;
    }
}