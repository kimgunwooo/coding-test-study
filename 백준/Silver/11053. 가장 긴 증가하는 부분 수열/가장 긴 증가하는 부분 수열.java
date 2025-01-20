import java.io.*;
import java.util.*;

/**
 * 시간 제한 1초
 * 메모리 제한 256 MB
 * ---
 * 수열에서 가장 긴, 증가하는 부분 수열을 구하라
 * ex) A = {10, 20, 10, 30, 20, 50} -> 10, 20, 30, 50 길이는 4
 * ---
 * N (1 ≤ N ≤ 1,000)
 * ---
 * 수열을 진행해가면서 자기보다 큰 값이 나오면 증가시키는 매커니즘으로 진행
 */

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    public static int R = 0;
    public static int G = 1;
    public static int B = 2;

    public static int N;
    public static int[] ary;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());

        ary = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            ary[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[N];
        Arrays.fill(dp, 1);
        for (int i=1; i<N; i++) {
            for (int j=i-1; j>=0; j--) {
                if (ary[i] > ary[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int max = 0;
        for (int i=0; i<N; i++) {
            max = Math.max(max, dp[i]);
        }
        System.out.println(max);
    }
}
