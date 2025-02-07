import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
1초 / 512MB
---
첫 번째 신호등은 1 시작 2주기로 초-빨-초 반복
12초 34빨 56초
차가 첫번째 신호등까지 3초 걸림. time = 3
이때, 5초에 출발.

두 번째 신호등에
5 + (7-3) 로 9초에 도착.
두 번째 신호등은 1시작 5주기로
12345초 678910빨 11초
즉, 11초에 출발해서 다음 신호등이 존재하지 않기에
11 + (10-7) = 14

신호가 갈수 있는 신호인지 체크. (짝수 주기인 경우에만 가능)

---
T <= 100,000
N <= 10^18
K <= 10^18
 */
class Sign implements Comparable<Sign>{
    int i;
    int rot;
    int start;
    public Sign(int i, int rot, int start) {
        this.i = i;
        this.rot = rot;
        this.start = start;
    }
    public int compareTo(Sign o) {
        return this.i - o.i;
    }
}
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Sign[] signs = new Sign[k];
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int rot = Integer.parseInt(st.nextToken());
            int start = Integer.parseInt(st.nextToken());
            signs[i] = new Sign(x, rot, start);
        }

        Arrays.sort(signs);

        long time = getTime(signs, n);
        System.out.println(time);
    }

    private static long getTime(Sign[] signs, int n) {
        int pos = 0; // 현재 좌표
        long time = 0; // 현재 시간
        for (Sign sign : signs) {
            int x = sign.i;
            int t = sign.rot;
            int s = sign.start;

            time += x - pos; // 온 거리만큼 시간 증가
            pos = x; // 현재 위치 업데이트

            // 대기시간 처리
            time += cw(time, t, s);
        }

        // 마지막 신호등에서 거리 끝까지 처리
        time += (n - pos);
        return time;
    }

    public static long cw(long time, int period, int start) {
        if (time < start) {
            return start - time;
        }
        long now = time - start;
        long sw = (now / period) % 2;
        return sw * (period - (now % period));
    }
}