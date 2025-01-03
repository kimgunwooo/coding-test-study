import java.io.*;
import java.util.*;

/**
 * 시간 제한 1초
 * 메모리 제한 128 MB
 * ---
 * 1 - 2
 * 2 - 5
 * 3 - 5
 * 4 - 4
 * 5 - 5
 * 6 - 6
 * 7 - 3
 * 8 - 7
 * 9 - 6
 * 0 - 6
 *
 * (2 ≤ n ≤ 100)
 * 모두사용해서 만들 수 있는 가장 작은수와 큰 수 찾기
 * 일단 8이상부터 구해보기?
 * 개수   8    9      10      11      12      13          14          15
 * 최소   10   18     22      26      28      68          88          108
 * 최대   1111 7111   11111   71111   111111
 *
 * 최대 : 짝수면 /2 만큼의 1이 필요. 홀수라면 /2 나온개수의 앞자리만 7로
 * 최소 : 9=2-7, 10=5-5, 11=5-6
 *
 * 0 1 2 3 4 5      6      7
 *     1 7 4 2,3,5  0,6,9  8
 */

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    public static int N;
    public static long[] minDp;
    public static String[] maxDp;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());

        minDp = new long[101];
        maxDp = new String[101];

        // 최대 DP 배열 초기값 설정
        maxDp[2] = "1";
        maxDp[3] = "7";
        for (int i = 4; i <= 100; i++) {
            String temp = "";
            if (i % 2 == 0) { // 짝수라면
                for (int j=0; j<i/2; j++) {
                    temp += "1";
                }
            } else { // 홀수라면
                temp += "7";
                for (int j=1; j<i/2; j++) {
                    temp += "1";
                }
            }
            maxDp[i] = temp;
        }

        // 최소 DP 배열 초기값 설정
        Arrays.fill(minDp, Long.MAX_VALUE); // overflow를 방지하기 위해서 초기 minDp의 값을 모두 max값으로 초기화
        minDp[2] = 1;
        minDp[3] = 7;
        minDp[4] = 4;
        minDp[5] = 2;
        minDp[6] = 6;
        minDp[7] = 8;
        minDp[8] = 10;
        String[] ary = {"1","7","4","2","0","8"};
        for (int i = 9; i<=100; i++) {
            for (int j=2; j<=7; j++) {
                String temp = minDp[i-j] + ary[j-2];
                minDp[i] = Math.min(Long.parseLong(temp), minDp[i]);
            }
        }

        for (int tc=0; tc<N; tc++) {
            int n = Integer.parseInt(br.readLine());
            sb.append(minDp[n]).append(" ").append(maxDp[n]).append("\n");
        }
        System.out.println(sb);
    }
}