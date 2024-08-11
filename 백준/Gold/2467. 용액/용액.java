import java.io.*;
import java.util.*;

/**
 * 1 ≤ N ≤ 100,000
 * -1,000,000,000 ≤ num ≤ 1,000,000,000
 * 시간 제한 1초
 * 메모리 제한 128 MB
 * ---
 * 각 배열에서 2개를 골라 합이 0에 가장 가까운 정수의 짝을 찾으면 됨.
 * 오름차순으로 제공된다. 그렇기에 이분탐색? 투포인터?
 */

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringBuilder sb = new StringBuilder();
	public static StringTokenizer st;
	public static int[] nums;

	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine());
		nums = new int[N];

		st = new StringTokenizer(br.readLine(), " ");
		for (int i=0; i<N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}

		solution();

		System.out.println(sb);
	}

	private static void solution() {
		int min = Integer.MAX_VALUE;
		int left = 0;
		int right = nums.length - 1;
		int n1 = 0;
		int n2 = 0;
		while (left < right) {
			int sum = nums[left] + nums[right];
			if (min > Math.abs(sum)) {
				min = Math.abs(sum);
				n1 = nums[left];
				n2 = nums[right];
			}

			if (sum >= 0) right--;
			else left++;
		}
		sb.append(n1).append(" ").append(n2);
	}
}