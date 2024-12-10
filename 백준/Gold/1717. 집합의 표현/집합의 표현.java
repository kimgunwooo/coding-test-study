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

    public static int n, m;
    public static int[] parent;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        parent = new int[n+1];
        for (int i=1; i<=n; i++) {
            parent[i] = i;
        }

        for (int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (command == 0) {
                union(a,b);
            } else if (command == 1) {
                if (find(a) == find(b)) sb.append("YES\n");
                else sb.append("NO\n");
            }
        }
        System.out.println(sb);
    }

    private static void union(int n, int m) {
        n = find(n);
        m = find(m);

        if (n != m) {
            if (n < m) {
                parent[m] = n;
            } else {
                parent[n] = m;
            }
        }
    }

    private static int find(int n) {
        if (parent[n] == n) return n;
        return parent[n] = find(parent[n]);
    }
}