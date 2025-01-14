import java.io.*;
import java.util.*;

/**
 * 시간 제한 1.5초
 * 메모리 제한 256 MB
 * ---
 * 정렬되어 있는 두배열을 합쳐서 정렬한 뒤, 출력
 * 중복을 제거하면서 오름차순으로 정렬한 뒤, 출력하면 됨
 * (1 ≤ N, M ≤ 1,000,000)
 * 각 배열의 수는 절대값이 10^9 보다 작음 1_000_000_000
 *
 * 각 배열에서 중복값이 있다면 그건 그대로 출력해야함.
 * 대신 서로 배열에서 중복값이 존재한다면 그건 제거해야함.
 */

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    public static int N, M;
    public static int ary[];

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        ary = new int[N + M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            ary[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            ary[N + i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(ary);

        for (int num : ary) {
            sb.append(num).append(" ");
        }
        System.out.println(sb);
    }
}
