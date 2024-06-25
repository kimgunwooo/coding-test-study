import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.StringTokenizer;

/**
 * 최대 100_000번 반복.
 * 최대 100_000개의 if 문이 존재 가능
 * 1_000_000_000 까지의 정수 값으로 상한을 표시
 *
 */

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringBuilder sb = new StringBuilder();
	public static StringTokenizer st;
	public static int N,M;
	public static Member[] members;

	public static class Member {
		String name;
		long bound;

		public Member(String name, long bound) {
			this.name = name;
			this.bound = bound;
		}
	}

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken()); // 칭호의 개수
		M = Integer.parseInt(st.nextToken()); // 캐릭터들의 개수

		members = new Member[N];

		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine()," ");
			String name = st.nextToken();
			long bound = Long.parseLong(st.nextToken());
			members[i] = new Member(name, bound);
		}

		for(int i=0;i<M;i++) {
			long power = Long.parseLong(br.readLine());
			solution(power);
		}

		System.out.println(sb);
	}

	private static void solution(long power) {
		int start = 0;
		int end = N-1;

		while(start <= end) {
			int mid = (start+end)/2;

			if(power <= members[mid].bound) {
				end = mid - 1;
			}
			else if(power > members[mid].bound) {
				start = mid + 1;
			}
		}

		sb.append(members[start].name).append("\n");
	}
}