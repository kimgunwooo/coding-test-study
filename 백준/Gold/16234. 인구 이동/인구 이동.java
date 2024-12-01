import java.io.*;
import java.util.*;

/**
 * 시간 제한 2초
 * 메모리 제한 512 MB
 * ---
 * (1 ≤ N ≤ 50, 1 ≤ L ≤ R ≤ 100)
 * 인구 이동이 발생하는 일수는 2000보다 작음
 * 그래프 형식으로 이어지기에 dfs 적용
 */

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    public static int N, L, R;
    public static int[][] ground;
    public static boolean[][] visited;
    public static int[] dx = {0, 1, 0, -1};
    public static int[] dy = {1, 0, -1, 0};
    public static List<Point> list;

    public static class Point {
        int i;
        int j;

        public Point(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        ground = new int[N][N];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                ground[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int day = 0;
        while(true) {
            boolean isMove = false;
            visited = new boolean[N][N];

            for(int i=0; i<N; i++) {
                for(int j=0; j<N; j++) {
                    if(!visited[i][j]) {
                        int sum = bfs(i, j);
                        if(list.size() > 1) {
                            changeToAvg(sum);
                            isMove = true;
                        }
                    }
                }
            }
            if(!isMove) {
                System.out.println(day);
                break;
            }
            day++;
        }
    }

    private static void changeToAvg(int sum) {
        int avg = sum / list.size();
        for(Point p : list) {
            ground[p.i][p.j] = avg;
        }
    }

    private static int bfs(int i, int j) {
        Queue<Point> q = new LinkedList<>();
        list = new ArrayList<>();

        q.offer(new Point(i, j));
        list.add(new Point(i, j));
        visited[i][j] = true;

        int sum = ground[i][j];
        while(!q.isEmpty()) {
            Point cur = q.poll();

            for(int k=0; k<4; k++) {
                int mx = cur.i + dx[k];
                int my = cur.j + dy[k];
                if(mx < 0 || mx >= N || my < 0 || my >= N || visited[mx][my]) continue;
                int diff = Math.abs(ground[mx][my] - ground[cur.i][cur.j]);
                if (diff >= L && diff <= R) {
                    q.offer(new Point(mx, my));
                    list.add(new Point(mx, my));
                    sum += ground[mx][my];
                    visited[mx][my] = true;
                }
            }
        }
        return sum;
    }
}