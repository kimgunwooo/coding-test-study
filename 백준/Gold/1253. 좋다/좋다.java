import java.io.*;
import java.util.*;

/**
 * 시간 제한 2초
 * 메모리 제한 256 MB
 * ---
 * N(1 ≤ N ≤ 2,000)
 * N개의 수중에서 어떤 수가 다른 수 2개의 합으로 나타낼 수 있는지 체크
 * 수의 위치가 다르면 다른 수
 *
 * 1,2,3,4,5,6,7,8
 *
 * 음수가 있을수도 있기 떄문에 모든 경우에 대해서 검사해야함
 */

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    public static int N;
    public static int count = 0;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        int[] ary = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            ary[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(ary);

        for (int i=0; i<N; i++) {
            solution(ary, i);
        }

        System.out.println(count);
    }

    private static void solution(int[] ary, int idx) {
        int left = 0;
        int right = N-1;

        while (left < right) {
            if (left == idx) left++;
            else if (right == idx) right--;

            if (left == right) return;

            if (ary[left] + ary[right] > ary[idx]) {
                right--;
            } else if (ary[left] + ary[right] < ary[idx]) {
                left++;
            } else { // 같을 때 == 찾았을 때
                count++;
                return;
            }
        }
    }
}