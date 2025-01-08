import java.io.*;
import java.util.*;

/**
 * 시간 제한 2초
 * 메모리 제한 512 MB
 * ---
 * 총감독관은 B명 담당, 부감독관은 C명 담당
 * 각각의 시험장에 총감독관은 오직 1명, 부감독관은 여러명
 *
 * 각 시험장의 응시생을 모두 감독하기 위해 필요한 감독관의 최소 수 구하기
 */

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    public static int N;
    public static long B, C;
    public static int[] tester;
    public static long count = 0;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());

        tester = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            tester[i] = Integer.parseInt(st.nextToken());

        }

        st = new StringTokenizer(br.readLine());

        B = Long.parseLong(st.nextToken());
        C = Long.parseLong(st.nextToken());

        for (int i = 0; i < N; i++) {
            tester[i] -= B;
            count++;
            if (tester[i] > 0) {
                count += tester[i] / C;
                if (tester[i] % C != 0) {
                    count++;
                }
            }
        }

        System.out.println(count);
    }
}