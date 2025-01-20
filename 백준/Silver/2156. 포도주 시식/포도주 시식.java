import java.io.*;
import java.util.*;

/**
 * 시간 제한 2초
 * 메모리 제한 128 MB
 * ---
 * 포도주 잔을 선택하면 그 잔에 들어있는 포도주는 모두 마셔야 하고, 마신 후에는 원래 위치에 다시 놓아야 한다.
 * 연속으로 놓여 있는 3잔을 모두 마실 수는 없다.
 * 가장 많은 양의 포도주를 마실 수 있도록
 * ex) 6, 10, 13, 9, 8, 1 -> 1 - 2 - 4 - 5 순으로 먹으면 최대 = 33
 * ---
 * N (1 ≤ N ≤ 10,000)
 * ---
 * dp[1] = 6
 * dp[2] = 16
 * dp[3] = 23
 * dp[4] = 28
 * dp[5] = 33
 * dp[6] = 33
 * // 점화식
 * dp[i] = (dp[i-1]) (dp[i-3]+ary[i-1]+ary[i]) (dp[i-2]+ary[i]) 이 3개 중에 최대값
 */

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    public static int N;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());

        int[] ary = new int[N+1];
        int[] dp = new int[N+1];
        for (int i=1; i<=N; i++) {
            ary[i] = Integer.parseInt(br.readLine());
        }

        dp[1] = ary[1];
        if (N > 1) dp[2] = ary[1] + ary[2];

        for (int i=3; i<=N; i++) {
            dp[i] = Math.max(dp[i-1], Math.max(dp[i-3]+ary[i-1]+ary[i],dp[i-2]+ary[i]));
        }

        System.out.println(dp[N]);
    }
}
