import java.io.*;
import java.util.*;

/**
 * 시간 제한 1초
 * 메모리 제한 128 MB
 * ---
 * 전깃줄 <= 100
 * 위치 <= 500
 *
 * 처음부터
 *
 */

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    public static int N;
    static int[] dp;
    static int[][] line;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());

        dp = new int[N];
        line = new int[N][2];
        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            line[i][0] = Integer.parseInt(st.nextToken());
            line[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(line, new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        int max = 0;
        for (int i=0; i<N; i++) {
            max = Math.max(solution(i), max);
        }

        System.out.println(N - max);
    }

    private static int solution(int n) {
        if (dp[n] == 0) {
            dp[n] = 1;

            for (int i = n+1; i<N; i++) {
                if (line[n][1] < line[i][1]) {
                    dp[n] = Math.max(dp[n], solution(i) + 1);
                }
            }
        }
        return dp[n];
    }
}