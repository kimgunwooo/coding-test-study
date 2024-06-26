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
	public static PriorityQueue<Long> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

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
			if(maxHeap.isEmpty()) {
				sb.append(0).append("\n");
				return;
			}
			long min = maxHeap.remove();
			sb.append(min).append("\n");
		} else { // 추가
			maxHeap.add(x);
		}
	}
}