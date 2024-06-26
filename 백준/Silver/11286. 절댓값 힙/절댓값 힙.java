import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.StringTokenizer;

/**
 *
 */

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringBuilder sb = new StringBuilder();
	public static StringTokenizer st;
	public static int N;
	public static PriorityQueue<AbsNum> absHeap = new PriorityQueue<>();

	public static class AbsNum implements Comparable<AbsNum> {
		long x;

		public AbsNum(long x) {
			this.x = x;
		}

		@Override
		public int compareTo(AbsNum absNum) {
			if(Math.abs(this.x) < Math.abs(absNum.x)) {
				return -1;
			} else if (Math.abs(this.x) == Math.abs(absNum.x)){
				return (int)(this.x - absNum.x);
			} else {
				return 1;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine()); // 연산의 개수

		for(int i=0;i<N;i++) {
			long x = Long.parseLong(br.readLine());
			solution(x);
		}

		System.out.println(sb);
	}

	private static void solution(long x) {
		if(x == 0) { // 가장 작은 값을 출력, 제거
			AbsNum num = absHeap.poll();
			if(num != null) {
				sb.append(num.x).append("\n");
			} else {
				sb.append(0).append("\n");
			}
		} else { // 추가
			absHeap.add(new AbsNum(x));
		}
	}
}