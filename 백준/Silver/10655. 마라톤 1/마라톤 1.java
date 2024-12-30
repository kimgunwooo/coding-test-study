import java.io.*;
import java.util.*;

/**
 * 시간 제한 1초
 * 메모리 제한 256 MB
 * ---
 * N (3 ≤ N ≤ 100_000)
 * 1 ~ N 모두 순서대로 방문
 * 1, N을 제외한 한개의 체크포인트를 몰래 뛰어넘으려함
 * 그때 최소거리를 계산
 * (x1,y1)과 (x2,y2) 점 간의 거리는 |x1-x2| + |y1-y2|
 *
 * 처음에 처음부터 끝까지의 길이를 구하고, 중간 길이를 하나씩 빼가면서 체크하기
 * sum - (cur, prev) - (cur, next) + (prev, next)
 */

class Point {
    int x;
    int y;
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    public static int N;
    public static List<Point> points;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        points = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            points.add(new Point(x, y));
        }

        int total_distance = 0;
        for (int i = 0; i < N-1; i++) {
            Point cur = points.get(i);
            Point next = points.get(i+1);
            total_distance += getDistance(cur, next);
        }

        int result = total_distance;
        for (int i = 1; i < N-1; i++) {
            Point prev = points.get(i-1);
            Point cur = points.get(i);
            Point next = points.get(i+1);
            int temp = total_distance - getDistance(cur, prev) - getDistance(cur, next) + getDistance(prev, next);
            result = Math.min(result, temp);
        }
        System.out.println(result);
    }

    private static int getDistance(Point p1, Point p2) {
        return Math.abs(p1.x - p2.x) + Math.abs(p1.y - p2.y);
    }
}