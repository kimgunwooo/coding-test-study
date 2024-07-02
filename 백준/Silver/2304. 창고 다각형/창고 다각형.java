import java.io.*;
import java.util.*;

/**
 * N < 1000
 * L, H < 1000
 * 주어진 시간 제한이 2초이기 때문에 브루트포스 방법이 가능하다.
 * 1. 기둥을 위치 순으로 정렬
 * 2. 한 기둥(i)을 중심으로 모든 기둥(j)을 탐색해간다
 * - i 기둥보다 작으면서 가장 큰 max 기둥을 찾는다.
 * 	if i 기둥보다 큰 기둥이 없는경우 -> i 기둥 넓이 + (max 기둥 위치 - i) * max 기둥 높이
 * 	if i 기둥보다 큰 기둥이 있는경우 -> (j 기둥 위치 - i) * i 기둥 높이
 */

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringBuilder sb = new StringBuilder();
	public static StringTokenizer st;
	public static List<Pillar> pillars = new ArrayList<>();

	public static class Pillar implements Comparable<Pillar> {
		int x;
		int y;

		public Pillar(int x, int y) {
			this.x = x;
			this.y = y;
		}

		public int compareTo(Pillar p) {
			return this.x - p.x;
		}
	}

	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine()); // 기둥의 수

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int L = Integer.parseInt(st.nextToken());
			int H = Integer.parseInt(st.nextToken());
			pillars.add(new Pillar(L, H));
		}
		int result = solution(N);
		System.out.println(result);
	}

	private static int solution(int N) {
		Collections.sort(pillars); // x축 순으로 정렬
		int result = 0;

		for (int i = 0; i < N;) {
			int j = i+1;
			int lowmax = j;
			for (; j < N; j++) {
				// i 기둥보다 작은 것들 중 제일 큰 기둥 찾기
				if (pillars.get(i).y > pillars.get(j).y) {
					if(pillars.get(lowmax).y < pillars.get(j).y) {
						lowmax = j;
					}
				} else break;
			}

			if (j >= N) { // i 보다 큰 기둥이 없을 때
				result += pillars.get(i).y;
				if(lowmax < N)
					result += (pillars.get(lowmax).x - pillars.get(i).x -1) * pillars.get(lowmax).y;
				i = lowmax;
			}
			else { // i보다 큰 기둥을 만났을 때
				result += pillars.get(i).y * (pillars.get(j).x - pillars.get(i).x);
				i = j;
			}
		}

		return result;

	}
}