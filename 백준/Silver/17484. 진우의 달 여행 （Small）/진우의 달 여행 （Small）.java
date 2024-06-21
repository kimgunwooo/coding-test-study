import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[][] spaceShip = new int[n][m];
		int[][][] dp = new int[n][m][3]; // 이전에 온 방향을 표시할 3차원

		// init
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0;j<m;j++) {
				spaceShip[i][j] = Integer.parseInt(st.nextToken());
				if(i==0) Arrays.fill(dp[i][j], spaceShip[i][j]);
				else Arrays.fill(dp[i][j], Integer.MAX_VALUE);
			}
		}

		/**
		 * 0 1 2 - 7시, 6시, 8시
		 */
		for(int i=1;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(j==0) { // 맨 왼쪽
					// 7시로 오는 경우 = 이전에 6시로 오는 경우 or 8시로 오는 경우 중 작은 값
					dp[i][j][0] = Math.min(dp[i-1][j+1][2], dp[i-1][j+1][1]) + spaceShip[i][j];
					// 6시로 오는 경우 = 이전에 7시인 경우
					dp[i][j][1] = dp[i-1][j][0] + spaceShip[i][j];
				} else if(j==m-1) { // 맨 오른쪽
					dp[i][j][1] = dp[i-1][j][2] + spaceShip[i][j];
					dp[i][j][2] = Math.min(dp[i-1][j-1][0], dp[i-1][j-1][1]) + spaceShip[i][j];
				} else { // 그 외 나머지
					dp[i][j][0] = Math.min(dp[i-1][j+1][1], dp[i-1][j+1][2]) + spaceShip[i][j];
					dp[i][j][1] = Math.min(dp[i-1][j][0], dp[i-1][j][2]) + spaceShip[i][j];;
					dp[i][j][2] = Math.min(dp[i-1][j-1][0], dp[i-1][j-1][1]) + spaceShip[i][j];;
				}
			}
		}

		int min = Integer.MAX_VALUE;
		for(int i = 0; i < m; i++) {
			for (int j = 0; j < 3; j++) {
				min = Math.min(min, dp[n - 1][i][j]);
			}
		}
		System.out.println(min);
	}
}