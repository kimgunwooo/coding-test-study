import java.io.*;
import java.util.*;

/**
 * 1 ≤ N ≤ 200_000, 2 ≤ K ≤ 100
 * 투포인터.
 */

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringBuilder sb = new StringBuilder();
	public static StringTokenizer st;
	public static int N, K;
	public static int[] window;
	public static Map<Integer, Integer> map = new HashMap<>();

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken()); // 개수
		K = Integer.parseInt(st.nextToken()); // 최대 중복 개수

		window = new int[N];

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			window[i] = Integer.parseInt(st.nextToken());
		}

		int result = solution();

		System.out.println(result);
	}

	private static int solution() {
		int start = 0;
		int end = 0;
		int result = 0;

		while(start < N) {
			while(end < N) {
				if(map.getOrDefault(window[end], 0) + 1 > K) { // 중복 개수가 K 이상이라면 중지
					break;
				}
				else { // 중복 개수 미만이라면 해당 숫자의 개수를 카운팅
					map.put(window[end], map.getOrDefault(window[end], 0) + 1);
				}

				end++;
			}

			result = Math.max(result, end-start);

			// 윈도우 이동
			map.put(window[start], map.get(window[start]) - 1);
			start++;
		}

		return result;
	}
}