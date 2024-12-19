import java.io.*;
import java.util.*;

/**
 * 시간 제한 2초
 * 메모리 제한 256 MB
 * ---
 *  (1 ≤ N, M ≤ 500,000, 1 ≤ L ≤ 100,000, 1 ≤ K ≤ 100)
 * 완전탐색 불가능
 * K가 100개 이하이기 때문에 K의 x,y 좌표를 추출해 좌 상단으로 잡고, L*L 범위 탐색을 진행한다.
 */

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    public static int N, M, L, K;
    public static List<int[]> stars;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken()); // 트랜펄린의 한변의 길이
        K = Integer.parseInt(st.nextToken()); // 별똥별의 수

        stars = new ArrayList<>();
        for (int i=0; i<K; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            stars.add(new int[]{x, y});
        }

        int max = Integer.MIN_VALUE;
        for (int[] s1 : stars) {
            for (int[] s2 : stars) {
                // 별들의 좌표에서 x, y 추출
                max = Math.max(max, findStarInBound(s1[0], s2[1]));
            }
        }
        System.out.println(K-max);
    }

    private static int findStarInBound(int x, int y) {
        int count = 0;
        for (int[] s : stars) {
            // 모든 별들에 대해서 x, y 좌표를 좌상단으로 한 L*L 바운더리 내에 포함되는지 체크
            if (s[0] >= x && s[0] <= x+L && s[1] >= y && s[1] <= y+L) {
                count++;
            }
        }
        return count;
    }
}