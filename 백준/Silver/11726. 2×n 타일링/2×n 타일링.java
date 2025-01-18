import java.io.*;
import java.util.*;

/**
 * 시간 제한 1초
 * 메모리 제한 256 MB
 * ---
 * 1 <= n <= 1_000
 * 2xn 크기의 직사각형을 1x2, 2x1로 채울 수 있는 방법의 수
 *
 * 가로로 들어가는 2x1이 어디에 위치할지에 따라 방법의 수가 나눠질 것 같다.
 * 1x2 만 들어가는 방법은 default 로 존재
 * 짝수일때 2x1 이 들어갈 개수가 늘어남.
 *
 *
 * dp[1] = 1
 * dp[2] = 2 (1x2 , 2x1)
 * dp[3] = 3 (1x2, 2x1-1x2 2개)
 * dp[4] = 5 (1x2, 2x1-1x2 3개, 2X1)
 * dp[5] = 8
 * dp[6] = 13
 *
 * 피보나치 수열?
 */

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    public static int N;
    public static int[] dp;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        dp = new int[1001];

        dp[1] = 1;
        dp[2] = 2;
        for (int i=3; i<=1000; i++) {
            // mod 연산을 각 연산마다 취해줘야 int Overflow를 방지할 수 있음
            dp[i] = (dp[i-1] + dp[i-2]) % 10_007;
        }

        System.out.println(dp[N]);
    }
}
