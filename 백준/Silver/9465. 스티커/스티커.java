import java.io.*;
import java.util.*;

/**
 * 1 ≤ N ≤ 100,000
 * 시간 제한 1초
 * 메모리 제한 256 MB
 * ---
 *
 */

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;
    public static int T;

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());

        for (int i=0; i<T; i++) {
            int N = Integer.parseInt(br.readLine());
            int[][] arr = new int[2][N+1];
            int[][] dp = new int[2][N+1];
            for (int j=0; j<2; j++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int k=1; k<=N; k++) {
                    arr[j][k] = Integer.parseInt(st.nextToken());
                }
            }

            dp[0][1] = arr[0][1];
            dp[1][1] = arr[1][1];
            for (int k=2; k<=N; k++) {
                dp[0][k] = Math.max(dp[1][k-1], dp[1][k-2]) + arr[0][k];
                dp[1][k] = Math.max(dp[0][k-1], dp[0][k-2]) + arr[1][k];
            }
            sb.append(Math.max(dp[1][N], dp[0][N])).append("\n");
        }
        System.out.print(sb);
    }
}