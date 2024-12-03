import java.io.*;
import java.util.*;

/**
 * 시간 제한 2초
 * 메모리 제한 128 MB
 * ---
 * (1 ≤ n ≤ 50,000)
 * 스카이라인으로 보이는 빌딩이 보일때, 최소 개수의 빌딩을 찾기
 * 빌딩은 직사각형 모양이다.
 *
 * ..........................
 * .....XX.........XXX.......
 * .XXX.XX.......XXXXXXX.....
 * XXXXXXXXXX....XXXXXXXXXXXX
 * x축 기준으로 봤을 떄, 가장 높은 y 축부터 1층까지 모두 체크
 * 끊기는 것들 기준으로 카운팅
 *
 * (1 ≤ x ≤ 1,000,000. 0 ≤ y ≤ 500,000)
 * 모든 배열에 접근하기는 불가능
 *
 * Stack을 활용해서 해결
 */

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    public static int N;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();

        int count = 0;
        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            while (!stack.isEmpty() && stack.peek() > y) {
                stack.pop();
                count++;
            }

            if (!stack.isEmpty() && stack.peek() == y) {
                continue;
            }

            stack.push(y);
        }

        while (!stack.isEmpty()) {
            if (stack.peek() > 0) {
                count++;
            }
            stack.pop();
        }

        System.out.println(count);
    }
}