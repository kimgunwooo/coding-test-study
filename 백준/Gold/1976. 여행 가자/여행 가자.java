import java.io.*;
import java.util.*;

/**
 * 시간 제한 2초
 * 메모리 제한 128 MB
 * ---
 * 집합을 통해 각 도시에서 최종 부모를 구해서 저장.
 * 처음 시작하는 도시와 연결되지 않다면 불가능.
 */

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    public static int N, M;
    public static int[] parent;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        parent = new int[N+1];
        for (int i=1; i<=N; i++) {
            parent[i] = i;
        }

        for (int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=1; j<=N; j++) {
                int chain = Integer.parseInt(st.nextToken());

                if (chain == 1) {
                    union(i, j);
                }
            }
        }

        st = new StringTokenizer(br.readLine());
        int start = find(Integer.parseInt(st.nextToken()));
        for (int i=1; i<M; i++) {
            int cur = Integer.parseInt(st.nextToken());

            if (start != find(cur)) {
                System.out.println("NO");
                return;
            }
        }

        System.out.println("YES");
    }

    private static int find(int n) {
        if (n == parent[n]) {
            return n;
        }

        return parent[n] = find(parent[n]);
    }

    private static void union(int i, int j) {
        i = find(i);
        j = find(j);

        if (i != j) {
            if (i < j) {
                parent[j] = i;
            } else {
                parent[i] = j;
            }
        }
    }
}