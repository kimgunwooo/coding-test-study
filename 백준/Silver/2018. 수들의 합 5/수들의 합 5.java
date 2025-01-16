import java.io.*;
import java.util.*;

/**
 * 시간 제한 2초
 * 메모리 제한 32 MB
 * ---
 * N 을 연속된 자연수의 합으로 나타낼 수 있는 개수를 출력
 * N(1 ≤ N ≤ 10,000,000)
 */

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    public static int N;
    public static int[] ary;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());

        ary = new int[N+2];
        for (int i = 1; i <= N+1; i++) {
            ary[i] = i;
        }

        int left = 0;
        int right = 0;
        int sum = 0;
        int count = 0;
        while (true) {
            if (sum <= N) {
                sum += ary[++right];
            } else if (right > N) break;
            else {
                sum -= ary[left++];
            }

            if (sum == N) {
                count++;
            }
        }
        System.out.println(count);
    }
}
