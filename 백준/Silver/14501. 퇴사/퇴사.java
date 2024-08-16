import java.io.*;
import java.util.*;

/**
 * 1 ≤ N ≤ 15
 * 시간 제한 2초
 * 메모리 제한 512 MB
 * ---
 * 시간이 넉넉하기 때문에 완전탐색인 DFS 를 사용해도 괜찮을 것 같다.
 *
 */

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;
    public static List<Counsel> counsels = new ArrayList<>();
    public static int max = Integer.MIN_VALUE;
    public static int N;

    public static class Counsel {
        int time;
        int price;

        public Counsel(int price, int time) {
            this.price = price;
            this.time = time;
        }
    }

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());

        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int time = Integer.parseInt(st.nextToken());
            int price = Integer.parseInt(st.nextToken());
            counsels.add(new Counsel(price, time));
        }

        dfs(0, 0);

        System.out.println(max);
    }

    private static void dfs(int day, int pay) {
        if (day >= N) {
            max = Math.max(max, pay);
            return;
        }

        if (day + counsels.get(day).time <= N) {
            dfs(day + counsels.get(day).time, pay + counsels.get(day).price);
        } else {
            dfs(day + counsels.get(day).time, pay);
        }
        dfs(day + 1, pay);
    }
}