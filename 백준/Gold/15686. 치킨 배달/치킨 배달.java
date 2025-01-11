import java.io.*;
import java.util.*;

/**
 * 시간 제한 1초
 * 메모리 제한 512 MB
 * ---
 * 거리는 |r1-r2| + |c1-c2| 으로 구현
 * 0은 빈칸, 1은 집, 2는 치킨집
 *
 * N(2 ≤ N ≤ 50) M(1 ≤ M ≤ 13)
 */

class Point {
    int x;
    int y;
    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    public static int[][] city;
    public static List<Point> house;
    public static List<Point> chicken;
    public static boolean[] open;

    public static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        city = new int[N][N];
        house = new ArrayList<>();
        chicken = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                city[i][j] = Integer.parseInt(st.nextToken());
                if (city[i][j] == 1) {
                    house.add(new Point(i, j)); // 집 위치 저장
                } else if (city[i][j] == 2) {
                    chicken.add(new Point(i, j)); // 치킨집 위치 저장
                }
            }
        }

        open = new boolean[chicken.size()];
        dfs(0, 0, M);
        System.out.println(result);
    }

    private static void dfs(int start, int depth, int M) {
        // 열린 치킨 가게가 M개 라면 거리 계산
        if (depth == M) {
            int res = 0;

            // 모든 집에 대해서 가장 가까운 열린 치킨집까지의 거리를 구해서 최솟값을 구함.
            for (int i = 0; i < house.size(); i++) {
                int temp = Integer.MAX_VALUE;

                for (int j = 0; j < chicken.size(); j++) {
                    if (open[j]) {
                        int distance = Math.abs(house.get(i).x - chicken.get(j).x) + Math.abs(house.get(i).y - chicken.get(j).y);
                        temp = Math.min(distance, temp);
                    }
                }
                res += temp;
            }
            result = Math.min(result, res);
            return;
        }
        // 백트래킹
        for (int i = start; i<chicken.size(); i++) {
            open[i] = true;
            dfs(i+1, depth+1, M);
            open[i] = false;
        }
    }
}
