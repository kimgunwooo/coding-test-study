import java.io.*;
import java.util.*;

/**
 * 1 ≤ N ≤ 12, 1 ≤ D ≤ 10_000
 * 그리디? DP?
 * 1. 지름길 정렬
 * 2. 가장 가까운 target 지름길 찾기
 * 3. 그 지름길과 이전 값 사이는 결과값에 덧셈
 * 4. target 지름길 start 이후부터 end 안에 있는 모든 지름길과 기본 길의 최솟값 찾기
 * 5. 최솟값을 결과 값에 더하고, 2번 부터 다시 반복
 *
 * 이 아이디어는 이전 지름길과 다음 지름길이 포함관계가 아닌 일부분만 겹친거라면 최악의 경우 모든 경우 탐색
 * N,D 의 값이 작고, 2초 제한이기에 풀 수 있을 것 같긴하지만 코드가 너무 복잡해버림.
 *
 * 차라리 모든 경우를 탐색할 거라면 재귀함수를 통해 해결하는게 코드상 깔끔할 것 같다.
 */

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringBuilder sb = new StringBuilder();
	public static StringTokenizer st;
	public static int N, D;
	public static List<ShortPath> shortPaths = new ArrayList<>();

	public static class ShortPath implements Comparable<ShortPath>{
		int from, to, dist;

		public ShortPath(int from, int to, int dist) {
			this.from = from;
			this.to = to;
			this.dist = dist;
		}

		@Override
		public int compareTo(ShortPath s) {
			return this.from - s.from;
		}
	}

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken()); // 개수
		D = Integer.parseInt(st.nextToken()); // 고속도로 길이

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken()); // 시작
			int to = Integer.parseInt(st.nextToken()); // 끝
			int dist = Integer.parseInt(st.nextToken()); // 지름길의 길이

			if (from > D) continue; // 넘어가면
			if (to - from <= dist) continue; // 더 걸린다면
			shortPaths.add(new ShortPath(from, to, dist));
		}

		Collections.sort(shortPaths);
		int result = solution();

		System.out.println(result);
	}

	private static int solution() {
		int current = 0;
		int[] dp = new int[10_000];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;
		int i = 0;

		while (current < D) {
			if (i < shortPaths.size()) {
				ShortPath sp = shortPaths.get(i);
				if (current == sp.from) {
					dp[sp.to] = Math.min(dp[sp.to], dp[current] + sp.dist);
					i++;
				} else {
					dp[current + 1] = Math.min(dp[current + 1], dp[current] + 1);
					current++;
				}
			} else {
				dp[current + 1] = Math.min(dp[current + 1], dp[current] + 1);
				current ++;
			}
		}

		return dp[D];
	}
}