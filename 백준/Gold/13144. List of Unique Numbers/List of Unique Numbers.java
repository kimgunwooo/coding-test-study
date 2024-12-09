import java.io.*;
import java.util.*;

/**
 * 시간 제한 1초
 * 메모리 제한 32 MB
 * ---
 * (1 ≤ N ≤ 100,000)
 * 중복은 체크하지 않으면서 연속한 수를 뽑았을 때 같은 수가 여러번 등장하는지/안하는지만 판단하면 됨
 *
 * i번째 자리에서 나올 수 있는 카운트 세기?
 * 해당 자리에서 나올 수 있는 수는 l - r + 1
 */

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    public static int N;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        int[] ary = new int[N+1];

        for (int i=1; i<=N; i++) {
            ary[i] = Integer.parseInt(st.nextToken());
        }

        int[] check = new int[100_001];
        long result = 0;
        int l = 1;
        int r = 0;
        while (l <= N) {
            while (r+1 <= N && check[ary[r+1]] == 0) {
                check[ary[++r]]++;
            }

            result += r - l + 1;
            check[ary[l++]]--;
        }

        System.out.println(result);
    }
}