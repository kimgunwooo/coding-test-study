import java.io.*;
import java.util.*;
import javax.swing.JInternalFrame;

/**
 * 시간 제한 2초
 * 메모리 제한 256 MB
 * ---
 * 말이 같은 칸을 지나지 않으며 최대 몇칸을 지날 수 있는지 구하기
 * 최대 20x20 의 사이즈
 * C개의 알파벳 존재
 */

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;
    public static int R, C;

    public static char[][] board;
    public static boolean[] visited = new boolean[26];
    public static int[] dx = {1, -1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};
    public static int result = 0;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        board = new char[R][C];

        for (int i=0; i<R; i++) {
            String str = br.readLine();
            for (int j=0; j<C; j++) {
                board[i][j] = str.charAt(j);
            }
        }

        solution(0, 0, 1);
        System.out.println(result);
    }

    private static void solution(int x, int y, int depth) {
        result = Math.max(result, depth);
        visited[board[x][y] - 65] = true;

        for (int i=0; i<4; i++) {
            int mx = x + dx[i];
            int my = y + dy[i];
            if (mx < 0 || mx >= R || my < 0 || my >= C || visited[board[mx][my] - 65]) continue;
            solution(mx, my, depth+1);
            visited[board[mx][my] - 65] = false;
        }
    }
}