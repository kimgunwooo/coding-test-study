import java.io.*;
import java.util.*;

/**
 * 시간 제한 2초
 * 메모리 제한 512 MB
 * ---
 * N은 짝수
 *
 * ij , ji
 * ex) 1,2 3,4  팀이라면 12 + 21 , 34 + 43 으로 계산
 * N=4 - 2 [(1,2), (3,4)] , [(1,3), (2,4)]
 * N=6 - 4 []
 *
 * 두 팀의 능력이 차이를 최소로해야함
 * 재귀를 통해 모든 경우를 탐색하면 됨
 */

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    public static int N;
    public static int[][] team;
    public static boolean[] visited;

    public static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());

        team = new int[N][N];
        visited = new boolean[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                team[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        solution(0, 0);

        System.out.println(result);
    }

    static void solution(int idx, int depth) {
        if (depth == N / 2) { // 팀 조합이 완성되는 경우
            diff(); // 각 팀의 능력치 차이 비교
            return;
        }

        for (int i = idx; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                solution(i + 1, depth + 1);
                visited[i] = false;
            }
        }
    }

    private static void diff() {
        int team_start = 0;
        int team_link = 0;

        for (int i = 0; i < N-1; i++) {
            for (int j = i+1; j < N; j++) {
                if (visited[i] && visited[j]) {
                    team_start += team[i][j] + team[j][i];
                }
                else if (!visited[i] && !visited[j]) {
                    team_link += team[i][j] + team[j][i];
                }
            }
        }

        int val = Math.abs(team_link - team_start);

        if (val == 0) {
            System.out.println(0);
            System.exit(0);
        }

        result = Math.min(result, val);
    }
}