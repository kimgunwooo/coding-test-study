import java.io.*;
import java.util.*;

/**
 * 시간 제한 1초
 * 메모리 제한 128 MB
 * ---
 * (1 ≤ A ≤ B ≤ 10^16)
 * 1의 개수 파악하기
 * --- 1자리 - 누적합 1
 * 0 - 0
 * 1 - 1
 * --- 2자리 - 누적합 4
 * 2 - 1
 * 3 - 2
 * --- 3자리 - 누적합 12
 * 4 - 1
 * 5 - 2
 * 6 - 2
 * 7 - 3
 * --- 4자리 - 누적합 32
 * 8 - 1
 * 9 - 2
 * 10 - 2
 * 11 - 3
 * 12 - 2
 * 13 - 3
 * 14 - 3
 * 15 - 4
 * ---
 *
 * DP[n] : 2ⁿ일 때 1의 개수 누적합
 * DP[n] = DP[n-1] x 2 + 2^n
 * DP[0] = 1
 * DP[1] = 1 x 2 + 2 = 4
 * DP[2] = 4 x 2 + 4 = 12
 * DP[3] = 12 x 2 + 8 = 32
 */

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    public static long A, B;
    public static long[] dp;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        A = Long.parseLong(st.nextToken());
        B = Long.parseLong(st.nextToken());

        dp = new long[55];
        dp[0] = 1;
        for (int i = 1; i < 55; i++) {
            // 비트 이동을 통해 (x2) 와 (2^n) 을 구현
            dp[i] = (dp[i-1] << 1) + (1L << i);
        }

        long result = calOne(B) - calOne(A-1);
        System.out.println(result);
    }

    static long calOne(long N) {
        // 홀수라면 1부터 시작 - 짝수라면 0으로 시작
        long count = N & 1;
        // N보다 작은 2ⁿ의 n의 최대값 (ex - 15 -> 3)
        int size = (int) (Math.log(N)/Math.log(2));
        //비트마스킹을 이용한 1의 개수 계산 진행
        //DP[i-1] : 000 ~ 111 개수
        //N - (1L << i) : 지정된 1이 반복 사용될 개수
        // + 1 : 1000...
        for(int i=size; i>0; i--) {
            if((N & (1L << i)) != 0L) { // 해당 비트가 1이라면
                count += dp[i-1] + (N - (1L << i) + 1);
                N -= (1L << i);	//비트 이동시키기
            }
        }
        return count;	//1의 개수 반환
    }
}