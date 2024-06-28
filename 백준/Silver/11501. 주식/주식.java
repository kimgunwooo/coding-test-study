import java.io.*;
import java.util.*;

/**
 * 역방향으로 탐색을 해서 최고값을 저장한다.
 * 만약 저장된 값보다 크다면, 업데이트를 하고
 * 저장된 값보다 작다면 그 차이를 저장하면 될 듯 하다.
 */

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringBuilder sb = new StringBuilder();
	public static StringTokenizer st;
	public static int[] values;


	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine()); // 테스트 케이스 수

		for(int i=0;i<T;i++) {
			int N = Integer.parseInt(br.readLine()); // 날의 수
			st = new StringTokenizer(br.readLine()," ");
			values = new int[N];

			for(int j=0;j<N;j++) { // 저장
				int p = Integer.parseInt(st.nextToken()); // 주식 가격
				values[j] = p;
			}

			solution();
		}
		System.out.println(sb);
	}

	private static void solution() {
		int max = 0;
		long result = 0;

		for(int i = values.length-1; i>=0; i--) {
			if(max < values[i]) {
				max = values[i];
				continue;
			}

			result += max - values[i];
		}

		sb.append(result).append("\n");
	}
}