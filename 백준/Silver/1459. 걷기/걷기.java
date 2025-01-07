import java.io.*;
import java.util.*;

/**
 * 시간 제한 2초
 * 메모리 제한 128 MB
 * ---
 * X와 Y는 1,000,000,000보다 작거나 같은 음이 아닌 정수
 * W와 S는 10,000보다 작거나 같은 자연수
 *
 * 상황을 생각해보면
 * 1. 직선으로만 이동 = (X+Y) * W
 * 2. 대각선만 이동 = max(X,Y) * S
 * 3. 대각선으로 이동 후, 직선으로 한칸 이동 = (max(X,Y)-1) * S + W
 * 4. 대각선으로 이동할만큼 이동하고, 나머지를 직선으로만 이동 = min(X,Y)*S + abs(X-Y)*W
 *
 * 여기서 도착하지 못하는데, 계산만 하는 경우가 생길 수 있음.
 * 그래서
 * 1. 직선으로만 이동은 제한사항이 없음.
 * 2. 대각선으로만 이동이 가능하려면, X+Y 가 짝수여야 함.
 * 3. 대각선으로 최대한 이동후에 한칸 이동하려면 X+Y 가 홀수여야함.
 * 4. 대각선으로 이동할만큼 이동하고, 나머지를 직선으로만 이동하는건 제한사항이 없음.
 */

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    public static long X, Y, W, S;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        X = Long.parseLong(st.nextToken());
        Y = Long.parseLong(st.nextToken());
        W = Long.parseLong(st.nextToken());
        S = Long.parseLong(st.nextToken());

        // 직선만
        long min = (X+Y)*W;

        if ((X+Y) % 2 == 0){ // 좌표합이 짝수라면
            // 대각선만
            min = Math.min(Math.max(X,Y)*S, min);
        }
        else { // 좌표함이 홀수라면
            // 대각선 + 직선하나
            min = Math.min((Math.max(X,Y)-1)*S+W, min);
        }

        // 대각선으로 갈 수 있을 만큼 가고, 직선으로 나머지를 감
        min = Math.min(Math.min(X,Y)*S + Math.abs(X-Y)*W, min);

        System.out.println(min);

    }
}