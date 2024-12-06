import java.io.*;
import java.util.*;
import javax.swing.JInternalFrame;

/**
 * 시간 제한 1초
 * 메모리 제한 128 MB
 * ---
 * (10 ≤ N < 100,000), (0 < S ≤ 100,000,000)
 * N 자리 수열, 연속된 수들의 부분합 중에 S 이상이 되는 가장 짧은 것의 길이 구하기
 *
 * 윈도우를 사용
 * 윈도우 내의 크기가 S보다 작다면 오른쪽으로 크기 증가
 * 윈도우 내의 크기가 S보다 크거나 같다면 왼쪽 크기를 감소. 최소값이라면 업데이트
 */

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;
    public static int N, S;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        int[] window = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            window[i] = Integer.parseInt(st.nextToken());
        }

        int sum = window[0];
        int left = 0;
        int right = 0;
        int min = 100_000;

        while (right < N && left <= right) {
            if (sum < S) {
                right++;
                if (right < N) {
                    sum += window[right];
                }
            }
            else if (sum >= S) {
                min = Math.min(min, right-left+1);
                sum -= window[left];
                left++;
            }
        }

        System.out.println(min == 100_000 ? 0 : min);
    }
}