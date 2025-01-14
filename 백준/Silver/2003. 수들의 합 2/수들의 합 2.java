import java.io.*;
import java.util.*;

/**
 * 시간 제한 0.5초
 * 메모리 제한 128 MB
 * ---
 * N 크기의 수열 안에서 i~j 수 까지의 합이 M이 되는 경우의 수를 구함
 *
 * N(1 ≤ N ≤ 10,000), M(1 ≤ M ≤ 300,000,000)
 *
 */

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    public static int N, M;
    public static int[] ary;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        ary = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            ary[i] = Integer.parseInt(st.nextToken());
        }

        int i = 0;
        int j = 0;
        int sum = 0;
        int count = 0;
        while (true) {
            if (sum >= M) { // M 보다 작다면 윈도우 왼쪽을 땡김
                sum -= ary[i++];
            } else if (j >= N) break; // 오른쪽 값이 범위를 넘어가면 종료
            else { // 범위를 넘어가지 않고, M보다 작다면 오른쪽 값 추가
                sum += ary[j++];
            }

            if (sum == M) {
                count++;
            }
        }
        System.out.println(count);
    }
}
