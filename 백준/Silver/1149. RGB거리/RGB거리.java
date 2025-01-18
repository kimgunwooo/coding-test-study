import java.io.*;
import java.util.*;

/**
 * 시간 제한 0.5초
 * 메모리 제한 128 MB
 * ---
 * 빨강, 초록, 파랑
 * - 1번 집의 색은 2번 집의 색과 같지 않아야 한다.
 * - N번 집의 색은 N-1번 집의 색과 같지 않아야 한다.
 * - i(2 ≤ i ≤ N-1)번 집의 색은 i-1번, i+1번 집의 색과 같지 않아야 한다.
 *
 * N(2 ≤ N ≤ 1,000)
 * 모든 집을 칠하는 비용의 최솟값 구하기
 *
 * 문제이해
 * R G B
 *
 */

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    public static int R = 0;
    public static int G = 1;
    public static int B = 2;

    public static int N;
    public static int[][] dp;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        dp = new int[N][3];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            dp[i][R] = Integer.parseInt(st.nextToken());
            dp[i][G] = Integer.parseInt(st.nextToken());
            dp[i][B] = Integer.parseInt(st.nextToken());
        }

        for (int i=1; i<N; i++) {
            dp[i][R] += Math.min(dp[i-1][G], dp[i-1][B]);
            dp[i][G] += Math.min(dp[i-1][R], dp[i-1][B]);
            dp[i][B] += Math.min(dp[i-1][R], dp[i-1][G]);
        }

        System.out.println(Math.min(Math.min(dp[N-1][R], dp[N-1][G]), dp[N-1][B]));
    }
}
