import java.io.*;
import java.util.*;

/*
2초, 512MB
---
테트로미노는 5가지 종류가 존재
N M 종위에 테트로미노 1개 놓기. 각각 칸에는 정수가 쓰여있음. 그 수 합을 최대로
테트로미노 회전 / 대칭 가능

(4 ≤ N, M ≤ 500) 최대 250,000 진행마다 4방향씩 탐색 4^3=64 이하
250,000 * 64 < 1억 으로 완전탐색 가능.

모든 테트로미노를 그려서 회전/대칭 시키기엔 너무 귀찮고 많다
그렇기에 DFS 를 통한 탐색으로 구현해보기

ㅗ/ㅜ/ㅓ/ㅏ 모양의 테트로미노는 백트래킹?
---
*/

public class Main {
    public static int n, m, result;
    public static int[][] map;
    public static boolean[][] visited;
    public static int[] dx = {1, -1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        result = Integer.MIN_VALUE;
        visited = new boolean[n][m];
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                visited[i][j] = true;
                dfs(i, j, 1, map[i][j]);
                visited[i][j] = false; // 모든 경우를 탐색하기 위한 백트래킹 처리
            }
        }

        System.out.println(result);
    }

    public static void dfs(int x, int y, int depth, int sum) {
        if (depth == 4) {
            result = Math.max(result, sum);
            return;
        }

        for (int i=0; i<4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || ny < 0 || nx >= n || ny >= m || visited[nx][ny]) continue;

            if (depth == 2) { // 두번째 위치까지 방문 처리됐을 경우 == ㅗ/ㅜ/ㅏ/ㅓ 의 중간 부분까지 도착한 경우
                visited[nx][ny] = true;
                // 현재 위치에서 다음 부분 방문 처리 후, 나머지 부분 중 하나를 방문해서 모양을 맞춤
                dfs(x, y, depth + 1, sum + map[nx][ny]);
                visited[nx][ny] = false;
            }

            visited[nx][ny] = true;
            dfs(nx, ny, depth+1, sum+map[nx][ny]);
            visited[nx][ny] = false; // 모든 경우를 탐색하기 위한 백트래킹 처리
        }
    }
}
