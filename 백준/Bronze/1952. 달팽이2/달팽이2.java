import java.io.*;
import java.util.*;

/*
2초, 128MB
---
M*N

ㅇ	→	↘
↗	↘	↓
↑	↓	↓
↑	끝	↓
↖	←	↙

이렇게 5번 꺾게됨.

최대 100*100 배열에서 모든 경우를 탐색하더라도 10000 밖에 안됨.
---
(2 ≤ M, N ≤ 100)
*/
public class Main {
    public static int m, n;
    public static boolean[][] visited;
    // 0 -> right, 1 -> down, 2 -> left, 3 -> up
    public static int[] dx = {1, 0, -1, 0};
    public static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        visited = new boolean[m][n]; // 방문 표시할 배열
        int nx = 0; // 현재 x
        int ny = 0; // 현재 y
        int idx = 0; // 방향을 설정할 인덱스 값
        int count = 0; // 꺾은 횟수
        int path = 0; // 지나온 길 == 종료조건

        // 초기값 설정
        visited[ny][nx] = true;
        path = 1;

        while (true) {
            int mx = nx + dx[idx];
            int my = ny + dy[idx];

            if (path == m*n) { // 모든 길을 지나오면 종료
                System.out.println(count);
                break;
            }

            // 다음 좌표가 갈 수 있는 좌표라면 이동
            if (mx >= 0 && my >= 0 && mx < n && my < m && !visited[my][mx]) {
                path++;
                visited[my][mx] = true;
                nx = mx;
                ny = my;
            }
            else { // 갈 수 없는 좌표라면 회전
                idx = (idx + 1) % 4; // 회전
                count++; // 꺾었으므로 증가
            }
        }
    }
}