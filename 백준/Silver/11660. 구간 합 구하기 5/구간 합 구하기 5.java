import java.io.*;
import java.util.*;

/*
1초, 256MB
---
2차원 배열에서 구간 내 합을 구하는 문제
N*N 배열 크기, 구해야 하는 횟수 M

무작정 구하면 최악의 경우 시간초과가 남 O(NM)

누적합 배열을 만들고, 끝 점의 합에서 시작 점의 합을 빼고 사이의 값을 출력하게 구현.
누적합 배열은 어떻게? -> 시작할 때 입력값을 받으면서 누적 배열에 값을 더하면서 저장하기
그렇다면 O(N+M) 으로 처리가능.
---
(1 ≤ N ≤ 1024, 1 ≤ M ≤ 100,000)
*/
public class Main {
    public static int n, m;
    public static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        dp = new int[n+1][n+1];
        for (int i=1; i<=n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=1; j<=n; j++) {
                int num = Integer.parseInt(st.nextToken());
                dp[i][j] = dp[i-1][j] + dp[i][j-1] - dp[i-1][j-1] + num;
            }
        }

        for (int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int result = dp[x2][y2] - dp[x1-1][y2] - dp[x2][y1-1] + dp[x1-1][y1-1];
            sb.append(result).append("\n");
        }

        System.out.print(sb);
    }
}