import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
2초 / 1024MB
---
To(n) = n의 약수이면서 홀수인 양의 정수 개수
Te(n) = n의 약수이면서 짝수인 양의 정수 개수

Te(x) = K x To(x) 만족하는 양의정수 x
N이하 양의 정수 x 구하기

규칙구하기
K=0 -> 약수중 짝수의 개수가 0 == 모든 홀수
K=1 -> 짝수 개수 == 홀수 개수 -> (약수가 홀수만 있는 수)홀수 * 2
K=2 -> 짝수 == 홀수 * 2 -> (홀수 * 2) *2
...

어떤 홀수 x * 2^k = 특별수
즉, N 이하의 홀수*2^k 의 개수를 구하면 된다.

이를 구하기 위해선 N 이하의 2^k의 모든 배수의 개수를 구한다.
여기서 홀수 배수만 거르기 위해선 N/2^k 값이 짝수인 경우 2로 나누고,
홀수인 경우 N/2^k - (N/2^k - 1) / 2 진행한다.

---
T <= 100,000
N <= 10^18
K <= 10^18
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        long[] pow = new long[64];
        pow[0] = 1;
        for (int i = 1; i <= 63; i++) {
            pow[i] = pow[i - 1] * 2;
        }

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());

            long N = Long.parseLong(st.nextToken());
            long K = Long.parseLong(st.nextToken());

            if (K >= 63) // 63 이상이면 범위를 넘어가 구할 수 없기에 0
                sb.append(0).append("\n");
            else {
                int tmp = (int) K;
                long ans = (N / pow[tmp]);
                if (ans % 2 == 0)
                    sb.append(ans / 2).append('\n');
                else
                    sb.append(ans - (ans - 1) / 2).append('\n');
            }
        }
        System.out.println(sb);
    }
}