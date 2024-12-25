import java.io.*;
import java.util.*;

/**
 * 시간 제한 1초
 * 메모리 제한 512 MB
 * ---
 * n (1 ≤ n ≤ 1,000) , w (1 ≤ w ≤ 100) and L (10 ≤ L ≤ 1,000)
 */

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    public static int n, w, L;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); // 트럭 수
        w = Integer.parseInt(st.nextToken()); // 다리의 길이
        L = Integer.parseInt(st.nextToken()); // 다리의 최대하중

        Queue<Integer> trucks = new LinkedList<>();
        Queue<Integer> queue = new LinkedList<>();

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++) {
            trucks.offer(Integer.parseInt(st.nextToken()));
        }

        int time = 0;
        int total_weight = 0;
        for (int i=0; i<w; i++) { // 다리의 길이만큼 0 추가
            queue.offer(0);
        }

        while (!queue.isEmpty()) {
            time++;
            total_weight -= queue.poll();
            if (!trucks.isEmpty()) {
                if (trucks.peek() + total_weight <= L) { // 다음 트럭이 건널 수 있는지?
                    total_weight += trucks.peek();
                    queue.offer(trucks.poll());
                } else {
                    queue.offer(0);
                }
            }
        }
        System.out.println(time);
    }
}