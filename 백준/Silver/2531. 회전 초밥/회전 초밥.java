import java.io.*;
import java.util.*;

/**
 * 1 ≤ N ≤ 30,000, 1 ≤ d, k ≤ 3,000, c ≤ d , k ≤ N
 * 모든 경우의 수가 가능하기에 brute force
 * sliding window 를 통해 검사. 근데, 쿠폰처리를 어떻게?
 * 사실 무료 초밥은 벨트 위에 없어도 새로 제공하기에 항상 존재한다고 처리해도 무관함.
 * 
 */

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;
    public static int N, d, k, c;
    public static int[] sushi;
    public static int[] window;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken()); // 놓인 접시의 수
        d = Integer.parseInt(st.nextToken()); // 초밥의 가짓수
        k = Integer.parseInt(st.nextToken()); // 연속해서 먹는 접시의 수
        c = Integer.parseInt(st.nextToken()); // 쿠폰 번호

        sushi = new int[N];

        for (int i = 0; i < N; i++) {
            sushi[i] = Integer.parseInt(br.readLine());
        }
        window = new int[d + 1];
        window[c] = 999999; // 대충 큰 값

        System.out.println(solution());
    }

    private static int solution() {
        int count = 1; // 항상 포함되도록
        int max = 0;
        for (int i = 0; i < k; i++) { // 처음 윈도우
            int a = sushi[i];
            if (window[a] == 0) {
                count++;
            }
            window[a]++;
        }
        max = count;

        for (int i = 0; i < N; i++) { // N-1 번 반복
            int start = sushi[i];
            int end = sushi[i + k >= N ? (i + k) % N : i + k];

            if (--window[start] == 0) { // 하나도 없다면
                count--;
            }
            if (++window[end] == 1) { // 처음이라면
                count++;
            }
            max = Math.max(max, count);
        }

        return max;
    }
}