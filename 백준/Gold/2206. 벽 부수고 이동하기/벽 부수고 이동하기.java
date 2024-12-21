import java.io.*;
import java.util.*;

/**
 * 시간 제한 2초
 * 메모리 제한 192 MB
 * ---
 * 0 = 이동할 수 있는 곳, 1 = 벽
 * 1,1 ~ N,M 까지의 최단경로 구하기
 * 시작하는 칸과 끝나는 칸 포함
 *
 * 만약 한개의 벽을 부수고 이동이 더 짧은 경로가 된다면 최대 1개 부수기 가능
 * 이동은 상하좌우
 *
 * N(1 ≤ N ≤ 1,000), M(1 ≤ M ≤ 1,000)
 *
 * 0100
 * 1110
 * 1000
 * 0000
 * 0111
 * 0000
 *
 * 만난 1을 모두 부셔보고 결정? -> 백트래킹으로 원상태 복구
 */

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    public static int N, M;
    public static int[][] map;
    public static int[][] dist;
    public static boolean[][][] visited;
    public static int[] dx = {1, -1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        dist = new int[N][M];
        visited = new boolean[2][N][M];
        for (int i=0; i<N; i++) {
            String str = br.readLine();
            for (int j=0; j<M; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }

        int result = bfs(0, 0);
        System.out.println(result);
    }

    private static int bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();

        queue.offer(new int[]{x, y, 0}); // 0 = 아직 부순적 없음
        dist[x][y] = 1;

        if (N-1 == 0 && M-1 == 0){
            return 1;
        }

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            for (int i=0; i<4; i++) {
                int mx = cur[0] + dx[i];
                int my = cur[1] + dy[i];
                if (mx < 0 || mx >= N || my < 0 || my >= M) continue;

                // 벽을 만났다면 벽을 부순적이 있는지 체크하고, 그 벽을 방문한적이 있는지 체크
                if (map[mx][my] == 1) {
                    if (cur[2] == 0 && !visited[1][mx][my]) {
                        visited[cur[2]][mx][my] = true;
                        dist[mx][my] = dist[cur[0]][cur[1]] + 1;
                        queue.offer(new int[]{mx, my, 1}); // 1 = 벽을 부숨
                    }
                } else { // 벽이 아니고, 방문하지 않았다면 방문처리후 거리계산 뒤, bfs 계속 진행
                    if (!visited[cur[2]][mx][my]) {
                        visited[cur[2]][mx][my] = true;
                        dist[mx][my] = dist[cur[0]][cur[1]] + 1;
                        queue.offer(new int[]{mx, my, cur[2]});
                    }
                }

                if (mx == N-1 && my == M-1) {
                    return dist[mx][my];
                }
            }
        }
        return -1;
    }
}