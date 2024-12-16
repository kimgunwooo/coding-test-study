import java.io.*;
import java.util.*;

/**
 * 시간 제한 1초
 * 메모리 제한 256 MB
 * ---
 * 1 ≤ R, C ≤ 1000
 * BFS의 조금 확장문제
 * 불의 번짐은 아무 영향도 안받기 때문에 먼저 BFS를 통해 확장시켜도 된다.
 * 지훈이의 이동은 불의 번짐에 대해 영향을 받는다.
 *
 * 불이 번질때마다 +1 연산을 통해 언제 불의 이동이 해당 칸으로 오는지 기록한다.
 * 지훈이는 다음칸으로 이동시에 다음칸으로 이동했을때 자신의 값이 해당 칸의 수보다 작을때만 이동한다.
 * 지훈이가 배열의 범위를 벗어나게 된다면 탈출을 성공한다.
 * 지훈이가 배열의 범위를 한번도 못벗어난다면 실패한다.
 *
 * # = -1
 * J = 0
 * F = 0
 */

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    public static int R, C;
    public static char[][] map;
    public static int[] dx = {1, -1, 0, 0};
    public static int[] dy = {0, 0, 1, -1};
    public static int[][] fireDist; // 불의 전파 시간
    public static int[][] JDist; // 지훈이의 이동 시간
    public static Queue<Point> fireQ = new LinkedList<>();
    public static Queue<Point> JQ = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        fireDist = new int[R][C];
        JDist = new int[R][C];

        for (int i=0; i<R; i++) {
            String str = br.readLine();
            for (int j=0; j<C; j++) {
                map[i][j] = str.charAt(j);
                JDist[i][j] = -1;
                fireDist[i][j] = -1;
                if (map[i][j] == 'J') {
                    JQ.add(new Point(i, j));
                    JDist[i][j] = 0;
                }
                if (map[i][j] == 'F') {
                    fireQ.add(new Point(i, j));
                    fireDist[i][j] = 0;
                }
            }
        }

        while (!fireQ.isEmpty()) {
            Point p = fireQ.poll();
            for (int i=0; i<4; i++) {
                int mx = p.x + dx[i];
                int my = p.y + dy[i];
                if (mx < 0 || mx >= R || my < 0 || my >= C) continue; // 배열 범위 넘어간다면
                if (fireDist[mx][my] >= 0 || map[mx][my] == '#') continue; // 방문했거나 벽이면
                fireDist[mx][my] = fireDist[p.x][p.y] + 1;
                fireQ.offer(new Point(mx, my));
            }
        }

        while (!JQ.isEmpty()) {
            Point p = JQ.poll();
            for (int i=0; i<4; i++) {
                int mx = p.x + dx[i];
                int my = p.y + dy[i];
                if (mx < 0 || mx >= R || my < 0 || my >= C) { // 배열 범위 넘어간다면
                    System.out.println(JDist[p.x][p.y] + 1);
                    return;
                }
                // 방문했거나 벽이거나 다음번쨰에 불이 존재한다면
                if (JDist[mx][my] >=0 || map[mx][my] == '#') continue;
                if (fireDist[mx][my] != -1 && JDist[p.x][p.y] + 1 >= fireDist[mx][my]) continue;
                JDist[mx][my] = JDist[p.x][p.y] + 1;
                JQ.offer(new Point(mx, my));
            }
        }

        System.out.println("IMPOSSIBLE");
    }

    public static class Point {
        int x;
        int y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}