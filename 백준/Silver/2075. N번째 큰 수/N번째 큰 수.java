import java.io.*;
import java.util.*;

/**
 * NxN 표의 각 컬럼은 오름차순으로 정렬되어 있다.
 * 여기서 N 번째 큰 수를 찾는 문제.
 * N은 최대 1500 으로 brute force 방법으로도 가능하다.
 * 대신 수의 크기가 -10억 < < 10억 이다.
 */

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringBuilder sb = new StringBuilder();
	public static StringTokenizer st;
	public static int[][] matrix;
	public static PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine());

		matrix = new int[N][N];

		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0;j<N;j++) {
				int num = Integer.parseInt(st.nextToken());
				queue.add(num);
			}
		}
		int result = solution(N);
		System.out.println(result);
	}

	private static int solution(int N) {
		for(int i=0;i<N-1;i++) {
			queue.poll();
		}
		return queue.poll();
	}
}