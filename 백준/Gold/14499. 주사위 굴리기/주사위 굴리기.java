import java.io.*;
import java.util.*;

/**
 * 시간 제한 1초
 * 메모리 제한 1024 MB
 * ---
 *   2
 * 4 1 3
 *   5
 *   6
 * 주사위는 다음과 같이 놓여져 있음. (x,y) 처음에는 모두 0
 * 이동한 칸에 쓰여 있는 수가 0이면 주사위 -> 칸으로 마주치면 복사
 * 0이아닌 경우, 칸 -> 주사위 바닥면으로 복사. 칸에 쓰인 수는 0
 *
 * 이동했을 때 마다 상단에 쓰여있는 값을 구해야 함.
 *
 * 지도의 세로N, 가로M 크기 (1 ≤ N, M ≤ 20)
 * 주사위의 좌표 x, y(0 ≤ x ≤ N-1, 0 ≤ y ≤ M-1),
 * 명령 수 K (1 ≤ K ≤ 1,000)
 * 동쪽은 1, 서쪽은 2, 북쪽은 3, 남쪽은 4
 *
 * 주사위를 어떻게 구현할 것인가?
 * - 주사위의 밑부분과 윗부분에 대한 내용을 알고 있어야 함.
 * - 동쪽 :
 */

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    public static int[] dice = new int[7];
    public static int[][] map;
    public static int N, M, x, y;
    public static int[] dx = {0, 1, -1, 0, 0};
    public static int[] dy = {0, 0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            int command = Integer.parseInt(st.nextToken());
            solution(command);
        }
    }

    private static void solution(int command) {
        int nx = x + dx[command];
        int ny = y + dy[command];
        if (nx < 0 || ny < 0 || nx >= M || ny >= N) return;
        roll(command, nx, ny);
        x = nx;
        y = ny;
    }

    static void roll(int d, int x, int y) {
        int tmp = dice[3];
        switch(d) {
            case 1:
                dice[3] = dice[4];
                dice[4] = dice[6];
                dice[6] = dice[2];
                dice[2] = tmp;
                break;
            case 2:
                dice[3] = dice[2];
                dice[2] = dice[6];
                dice[6] = dice[4];
                dice[4] = tmp;
                break;
            case 3:
                dice[3] = dice[5];
                dice[5] = dice[6];
                dice[6] = dice[1];
                dice[1] = tmp;
                break;
            case 4:
                dice[3] = dice[1];
                dice[1] = dice[6];
                dice[6] = dice[5];
                dice[5] = tmp;
                break;
        }
        if(map[y][x] == 0) {
            map[y][x] = dice[6];
        } else {
            dice[6] = map[y][x];
            map[y][x] =0;
        }
        System.out.println(dice[3]);

    }
}
