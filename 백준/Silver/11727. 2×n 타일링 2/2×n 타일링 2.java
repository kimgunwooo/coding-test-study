import java.io.*;
import java.util.*;

/**
 * 시간 제한 1초
 * 메모리 제한 256 MB
 * ---
 * 2xn 직사각형을 1x2, 2x1, 2x2 타일로 채우는 방법
 * ---
 * N (1 ≤ N ≤ 1,000)
 * ---
 * 1 - 1
 * 2 - 3
 * 3 - 5
 * 4 - 11
 * 5 - 21
 * 점화식은?
 * : 짝수일때 dp[i] = dp[i-1]*2 + 1
 * : 홀수일때 dp[i] = dp[i-1]*2 - 1
 */

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    public static int N;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());

        int[] dp = new int[N+1];
        dp[1] = 1;
        for (int i=2; i<=N; i++) {
            if (i % 2 == 0) {
                dp[i] = (dp[i-1]*2 + 1) % 10_007;
            } else {
                dp[i] = (dp[i-1]*2 - 1) % 10_007;
            }
        }

        System.out.println(dp[N]);
    }
}
