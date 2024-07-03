import java.io.*;
import java.util.*;

/**
 * 자기보다 큰 사람이 왼쪽에 몇명 있었는지 기억
 * N 명의 사람이 있고, 사람들의 키는 1~N 까지 모두 다름
 * N <= 10
 * 1은 제일 작은 값이기에 그 위치가됨.
 *
 */

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringBuilder sb = new StringBuilder();
	public static StringTokenizer st;
	public static int[] line;


	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine());

		line = new int[N+1];

		st = new StringTokenizer(br.readLine()," ");
		for(int i=1;i<N+1;i++) {
			int num = Integer.parseInt(st.nextToken());
			line[i] = num;
		}

		solution(N);
		System.out.println(sb);
	}

	private static void solution(int N) {
		int[] result = new int[N+1];

		for(int i=1;i<N+1;i++) {
			int count = 0;
			for(int j=1;j<N+1;j++) {
				if(result[j] == 0 || result[j] > i) {
					count++;
				}
				if(count > line[i] && result[j]==0) {
					result[j] = i;
					break;
				}
			}
		}

		for(int i=1;i<N+1;i++) {
			sb.append(result[i]).append(" ");
		}
	}
}