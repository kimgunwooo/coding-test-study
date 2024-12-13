import java.io.*;
import java.util.*;

/**
 * 시간 제한 1초
 * 메모리 제한 128 MB
 * ---
 * (2 ≤ N ≤ 200)
 * 예시에서는 삽입 정렬을 통해서 구현?
 * 삽입 정렬인데, 비교하는건 뭉탱이로 생각하고 최종 삽입 위치만 카운팅.
 *
 * LIS (최장 증가 부분 수열) 을 사용하면 쉽게 해결 가능하다.
 * [3, 7, 5, 2, 6, 1, 4] 에서는 3 5 6 이 된다.
 * 그래서 나머지 4개의 수들이 적당한 위치로 옮겨진다면 문제가 해결되게 된다.
 * 7 - 3 = 4
 */

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    public static int N;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());

        int[] children = new int[N];
        for (int i=0; i<N; i++) {
            children[i] = (Integer.parseInt(br.readLine()));
        }

        int LIS = findLIS(children);

        System.out.println(N - LIS);
    }

    private static int findLIS(int[] children) {
        int[] dp = new int[N];
        int max = 0;
        for (int i=0; i<N; i++) {
            dp[i] = 1; // 초기 값 설정
            for (int j=0; j<i; j++) {
                if (children[j] < children[i]) { // 선택된 i 전에서 작은값이 존재한다면
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }

        return max;
    }
}