import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.StringTokenizer;

/**
 * 1. 배열에 자연수 x를 넣는다.
 * 2. 배열에서 가장 작은 값을 출력하고, 그 값을 배열에서 제거한다.
 *
 * 우선순위 큐를 사용하면 FIFO 특징을 가짐.
 * 내부에서 힙으로 구성되어 이진트리 구조로 구성되어있음. O(n log n)
 */

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringBuilder sb = new StringBuilder();
	public static StringTokenizer st;
	public static int N;
	public static PriorityQueue<Long> minHeap = new PriorityQueue<>();

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
			if(minHeap.isEmpty()) {
				sb.append(0).append("\n");
				return;
			}
			long min = minHeap.remove();
			sb.append(min).append("\n");
		} else { // 추가
			minHeap.add(x);
		}
	}
}