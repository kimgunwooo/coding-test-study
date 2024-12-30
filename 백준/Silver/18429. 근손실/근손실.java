import java.io.*;
import java.util.*;

/**
 * 시간 제한 1초
 * 메모리 제한 256 MB
 * ---
 * 500으로 시작해서 매 반복마다 K만큼 감소함.
 * (1 ≤ N ≤ 8, 1 ≤ K ≤ 50)
 * 최대 8! 이기에 브루트포스 가능
 */

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    public static int N, K;
    public static int[] kit;
    public static boolean[] visited;
    public static int count = 0;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        kit = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            kit[i] = Integer.parseInt(st.nextToken());
        }

        visited = new boolean[N];
        dfs(500, 0);
        System.out.println(count);
    }

    private static void dfs(int weight, int depth) {
        if (depth == N) {
            count++;
            return;
        }

        for (int i=0; i<N; i++) {
            if (!visited[i] && (weight + kit[i] - K) >= 500) {
                visited[i] = true;
                dfs(weight + kit[i] - K, depth+1);
                visited[i] = false;
            }
        }
    }
}