import java.io.*;
import java.util.*;

/**
 * 시간 제한 0.15초
 * 메모리 제한 128 MB
 * ---
 * 1 <= N <= 1_000_000
 * 연산을 사용하는 횟수의 최솟값
 *
 * 1-0
 * 2 (첫 연산이 -1 /2  둘 중에 최소값) = min(1,1) = 1
 * 3 (첫 연산이 -1 /3 둘 중에 최소값) = min(2,1) = 1
 * 4 (-1 /2 최소값) = min(2, 2, 0) = 2
 * 5 (-1 ) = min(3) = 3
 * 6 (-1, /2, /3) = min(4, 2, 2) = 2
 * 7 (-1, - - ) = min(3) = 3
 *
 *
 */

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    public static int N;
    public static int[] dp;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        dp = new int[N+1];

        dp[1] = 0;
        // 첫 번째 연산을 기준으로 dp 배열 초기화
        for (int i=2; i<=N; i++) {
            dp[i] = dp[i-1] + 1; // -1로 시작하는 경우
            if (i%2 == 0) { // /2로 시작하는 경우
                dp[i] = Math.min(dp[i], dp[i/2] + 1);
            }
            if (i%3 == 0) { // /3으로 시작하는 경우
                dp[i] = Math.min(dp[i], dp[i/3] + 1);
            }
        }

        System.out.println(dp[N]);
    }
}
