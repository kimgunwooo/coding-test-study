import java.io.*;
import java.util.*;

/**
 * 시간 제한 2초
 * 메모리 제한 128 MB
 * ---
 * N(2 ≤ N ≤ 100,000)
 * 모든 경우의 수를 다 돌려보는 방법 은 불가능
 *
 * i-1, i, i+1 변경을 i, i+1, i+2 로 생각해서 해결하기
 * i 번째가 다르면 무조건 스위치를 누르면 됨.
 * 0번째가 없기에 1,2 시작을 그대로 or 12 반전 시작으로 O(N+N)
 */

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    public static int N;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        char[] origin = br.readLine().toCharArray(); // 그대로 시작
        char[] target = br.readLine().toCharArray();
        char[] reverse = Arrays.copyOf(origin, N); // 12 반전 시작

        reverse[0] = reverse[0] == '0' ? '1' : '0';
        reverse[1] = reverse[1] == '0' ? '1' : '0';

        int originCount = solution(origin, target, 0);
        int reverseCount = solution(reverse, target, 1);

        if (originCount == -1) {
            System.out.println(reverseCount);
        } else if (reverseCount == -1) {
            System.out.println(originCount);
        } else {
            System.out.println(Math.min(originCount, reverseCount));
        }
    }

    private static int solution(char[] ary, char[] target, int count) {
        for (int i=0; i<N-1; i++) {
            if (ary[i] != target[i]) {
                ary[i] = ary[i] == '0' ? '1' : '0';
                ary[i+1] = ary[i+1] == '0' ? '1' : '0';
                if (i != N-2) {
                    ary[i+2] = ary[i+2] == '0' ? '1' : '0';
                }
                count++;
            }
        }

        // 그리디 방식으로 순차적으로 변경해가기에
        // 가장 끝의 문자가 서로 다르면 불가능
        return ary[N-1] != target[N-1] ? -1 : count;
    }
}