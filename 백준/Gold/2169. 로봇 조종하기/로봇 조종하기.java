import java.io.*;
import java.util.*;

/**
 * 시간 제한 1초
 * 메모리 제한 512 MB
 * ---
 * 위쪽 이동은 불가능, 또한 한 번 탐사한 지역(배열에서 하나의 칸)은 탐사하지 않기로 함.
 * 탐사한 지역들의 가치의 합이 최대 찾기
 *
 * N, M (1≤N, M≤1,000)
 *
 * dfs로 완전탐색을 진행하려고하면 시간초과가 나게된다.
 * 그래서 DP 적으로 접근을 해야함.
 */

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    public static int N, M;
    public static int[][] mars, dp;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        mars = new int[N+1][M+1];
        dp = new int[N+1][M+1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                mars[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 1째줄 처리
        dp[1][1] = mars[1][1];
        for (int i = 2; i <= M; i++) {
            dp[1][i] = dp[1][i-1] + mars[1][i];
        }

        // 2~N 번줄까지의 처리
        for (int i = 2; i <= N; i++) {
            // 왼 -> 오 로 가면서 최대값 찾기
            int[] leftToRight = new int[M+1];
            leftToRight[0] = dp[i-1][1]; // 왼쪽 위의 값을 따로 저장
            for (int j=1; j<=M; j++) {
                // 왼->오 vs 위->아래 중 큰값으로 사용
                leftToRight[j] = Math.max(leftToRight[j-1], dp[i-1][j]) + mars[i][j];
            }

            // 오 -> 왼 으로 가면서 최대값 찾기
            int[] rightToLeft = new int[M+2];
            rightToLeft[M+1] = dp[i-1][M]; // 오른쪽 위의 값을 따로 저장
            for (int j=M; j>=1; j--) {
                // 오->왼 vs 위->아래 중 큰 값으로 사용
                rightToLeft[j] = Math.max(rightToLeft[j+1], dp[i-1][j]) + mars[i][j];
            }

            // 둘 중에서 최대값을 찾아서 dp 배열을 업데이트
            for (int j=1; j<=M; j++) {
                dp[i][j] = Math.max(leftToRight[j], rightToLeft[j]);
            }
        }

        System.out.println(dp[N][M]);
    }
}