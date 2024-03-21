import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 2차원 배열로 접근해야 한다.
 * 첫 번째 인자는 해당 숫자를 의미하고, 두 번째 인자는 해당 숫자로 끝나는 수식의 개수이다.
 * 여기서 주의할 점은 오름차순으로 정렬이 되어야 한다는 것이다.
 * 그래야 중복을 제거할 수 있다.
 * <p>
 * 4를 예로 들지면
 * 1. 4를 만들 수 있는 수식 중 1로 끝나는 수식은 '3을 만드는 수식 + 1' 이다.
 * dp[4][1] = dp[3][1]
 * 2. 4를 만들 수 있는 수식 중 2로 끝나는 수식은 '2를 만드는 수식 + 2' 이다.
 * dp[4][2] = dp[2][1] + dp[2][2]
 * 3. 4를 만들 수 있는 수식 중 3으로 끝나는 수식은 '1을 만드는 수식 + 3' 이다.
 * dp[4][3] = dp[1][1] + dp[1][2] + dp[1][3]
 * <p>
 * 최종 점화식은
 * dp[n][1] = dp[n-1][1]
 * dp[n][2] = dp[n-2][1] + dp[n-2][2]
 * dp[n][3] = dp[n-3][1] + dp[n-3][2] + dp[n-3][3]
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] dp = new int[10001][4];
        dp[1][1] = 1; // 1
        dp[2][1] = 1; // 1+1
        dp[2][2] = 1; // 2
        dp[3][1] = 1; // 1+1+1
        dp[3][2] = 1; // 1+2
        dp[3][3] = 1; // 3
        for(int i=4;i<10001;i++) {
             dp[i][1] = dp[i-1][1];
             dp[i][2] = dp[i-2][1] + dp[i-2][2];
             dp[i][3] = dp[i-3][1] + dp[i-3][2] + dp[i-3][3];
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n;i++) {
            int t = Integer.parseInt(br.readLine());
            sb.append(dp[t][1] + dp[t][2] + dp[t][3]).append("\n");
        }
        System.out.println(sb);

    }
}
