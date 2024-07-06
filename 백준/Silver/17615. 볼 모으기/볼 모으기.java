import java.io.*;
import java.util.*;

/**
 * 1 ≤ N ≤ 500,000
 * 그리디
 * R 이 왼쪽으로 몰릴 때, R이 오른쪽으로 몰릴 때, B가 왼쪽으로 몰릴 때, B가 오른쪽으로 몰릴 때
 * 결과는 같아보이지만, 내부 이동하는 로직이 다르기 때문에 주의
 * 500,000 * 4
 */

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;
    public static int N;
    public static char[] balls;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine()); // 개수
        String str = br.readLine();

        balls = str.toCharArray();

        int result = solution();

        System.out.println(result);
    }

    private static int solution() {
        boolean flag = false;
        int min = Integer.MAX_VALUE;
        int count = 0;

        for (int i=0; i<N; i++) { // R이 왼쪽
            if (flag && balls[i] == 'R') {
                count++;
            }
            else if(balls[i] == 'B') {
                flag = true;
            }
        }
        min = Math.min(min, count);

        count = 0;
        flag = false;
        for (int i=N-1; i>=0; i--) { // R이 오른쪽
            if (flag && balls[i] == 'R') {
                count++;
            }
            else if(balls[i] == 'B') {
                flag = true;
            }
        }
        min = Math.min(min, count);

        count = 0;
        flag = false;
        for (int i=0; i<N; i++) { // B가 왼쪽
            if (flag && balls[i] == 'B') {
                count++;
            }
            else if(balls[i] == 'R') {
                flag = true;
            }
        }
        min = Math.min(min, count);

        count = 0;
        flag = false;
        for (int i=N-1; i>=0; i--) { // B가 오른쪽
            if (flag && balls[i] == 'B') {
                count++;
            }
            else if(balls[i] == 'R') {
                flag = true;
            }
        }
        min = Math.min(min, count);

        return min;
    }
}