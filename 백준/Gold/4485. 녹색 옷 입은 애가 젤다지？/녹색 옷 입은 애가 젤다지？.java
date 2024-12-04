import java.io.*;
import java.util.*;

/**
 * 시간 제한 1초
 * 메모리 제한 256 MB
 * ---
 *
 */

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    public static int N;
    public static int[] dx = {0, 0, -1, 1};
    public static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        int count = 1;
        while (true) {
            N = Integer.parseInt(br.readLine());
            int[][] matrix = new int[N][N];

            if (N == 0) break;

            for (int i=0; i<N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j=0; j<N; j++) {
                    matrix[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int result = bfs(matrix);
            sb.append("Problem ").append(count).append(": ").append(result).append("\n");
            count++;
        }
        System.out.println(sb);
    }

    private static int bfs(int[][] matrix) {
        Queue<Node> queue = new PriorityQueue<>();
        int[][] dist = new int[N][N];

        for (int i=0; i<N; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
        dist[0][0] = matrix[0][0];
        queue.offer(new Node(0,0,matrix[0][0]));

        while (!queue.isEmpty()) {
            Node cur = queue.poll();

            for (int i=0; i<4; i++) {
                int mx = cur.x + dx[i];
                int my = cur.y + dy[i];

                if (mx < 0 || mx >= N || my < 0 || my >= N ) continue;

                if (dist[mx][my] > dist[cur.x][cur.y] + matrix[mx][my]) {
                    dist[mx][my] = dist[cur.x][cur.y] + matrix[mx][my];
                    queue.offer(new Node(mx, my, matrix[mx][my]));
                }
            }
        }

        return dist[N-1][N-1];
    }

    public static class Node implements Comparable<Node>{
        int x;
        int y;
        int value;

        public Node(int x, int y, int value) {
            this.x = x;
            this.y = y;
            this.value = value;
        }

        @Override
        public int compareTo(Node o) {
            return this.value - o.value;
        }
    }
}