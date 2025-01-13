import java.io.*;
import java.util.*;

/**
 * 시간 제한 10초
 * 메모리 제한 128 MB
 * ---
 * N(1 ≤ N ≤ 1,000,000)
 * 오름차순으로 정렬하면 됨.
 */

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;


    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        int[] ary = new int[N];
        for (int i=0; i<N; i++) {
            ary[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(ary);

        for (int i : ary) {
            sb.append(i).append("\n");
        }
        System.out.println(sb);
    }
}
