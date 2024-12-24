import java.io.*;
import java.util.*;

/**
 * 시간 제한 2초
 * 메모리 제한 512 MB
 * ---
 * N (1 ≤ N ≤ 5,000)
 * Q (1 ≤ Q ≤ 5,000)
 * (1 ≤ pi, qi ≤ N, 1 ≤ ri ≤ 1,000,000,000)
 *
 * 4 3
 * 1 2 3
 * 2 3 2
 * 2 4 4
 * 1 2
 * 4 1
 * 3 1
 *
 * USADO 는 경로간의 최소값으로 결정되기 때문에 BFS 탐색을 진행하면서 K 값보다 높아진다면 어저피 탐색하지 못하는 곳이다.
 * 그렇기에 K 값보다 작다면 탐색할 필요가 없기 때문에 BFS 탐색에 넣지 않는다.
 */
class Node {
    int node;
    int value;
    public Node(int node, int value) {
        this.node = node;
        this.value = value;
    }
}

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    public static int N, Q;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        List<Node>[] graph = new ArrayList[N + 1];

        for (int i=0; i<=N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i=0; i<N-1; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            graph[p].add(new Node(q, r));
            graph[q].add(new Node(p, r));
        }

        for (int i=0; i<Q; i++) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            Queue<Integer> queue = new LinkedList<>();
            boolean[] visited = new boolean[N + 1];
            int count = 0;

            visited[v] = true;
            queue.add(v);

            while (!queue.isEmpty()) {
                int cur = queue.poll();

                for (Node n : graph[cur]) {
                    if (!visited[n.node] && n.value >= k) {
                        queue.add(n.node);
                        visited[n.node] = true;
                        count++;
                    }
                }
            }

            sb.append(count).append("\n");
        }
        System.out.print(sb);
    }
}