import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

class Point {
    int z;
    int y;
    int x;
    public Point(int z, int y, int x) {
        this.z = z;
        this.y = y;
        this.x = x;
    }
}

public class Main {
    public static int[] dx = {1, -1 ,0 ,0, 0, 0 };
    public static int[] dy = {0 ,0 ,1, -1, 0, 0};
    public static int[] dz = {0, 0, 0, 0, 1, -1};
    static int m, n, h;
    static int[][][] box;
    static Queue<Point> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        /*
        m = 가로
        n = 세로
        h = 높이

        1 = 익은 토마토
        0 = 익지 않은 토마토
        -1 = 토마토가 들어있지 않은 칸
         */

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        box = new int[h][n][m];

        for(int i = 0; i < h; i++){
            for(int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                for(int k = 0; k < m; k++) {
                    box[i][j][k] = Integer.parseInt(st.nextToken());

                    if(box[i][j][k] == 1) {
                        queue.add(new Point(i,j,k));
                    }
                }
            }
        }

        System.out.println(bfs());

    }

    private static int bfs() {
        while(!queue.isEmpty()) {
            Point pt = queue.poll();

            for(int i = 0; i < 6; i++) {
                int mx = pt.x + dx[i];
                int my = pt.y + dy[i];
                int mz = pt.z + dz[i];

                if(Check(mx, my, mz)) {
                    queue.add(new Point(mz,my,mx));
                    box[mz][my][mx] = box[pt.z][pt.y][pt.x] + 1; // 이전 값의 +1로 다음(익은) 토마토를 설정
                }
            }
        }

        int result = Integer.MIN_VALUE;

        for(int i = 0; i < h; i++){
            for(int j = 0; j < n; j++) {
                for(int k = 0; k < m; k++) {
                    if(box[i][j][k] == 0) {
                        return -1;
                    }
                    result = Math.max(result, box[i][j][k]);
                }
            }
        }

        if(result == 1) { // 최대값이 1에서 증가되지 않았으면 저장될 떄부터 모든 토마토가 익은 것.
            return 0;
        }

        return result - 1;
    }

    private static boolean Check(int mx, int my, int mz) {
        if(mx < 0 || my < 0 || mz < 0 || mx >= m || my >= n || mz >= h) {
            return false;
        }
        if(box[mz][my][mx] == 0) { // 익지 않은 토마토라면
            return true;
        } else { // 익은 토마토거나 빈 곳이라면
            return false;
        }
    }
}