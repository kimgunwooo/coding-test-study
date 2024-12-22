import java.io.*;
import java.util.*;

/**
 * 시간 제한 1.5초
 * 메모리 제한 1024 MB
 * ---
 * 예전처럼 처음부터 오른쪽부분만 체크하면서 2중 for문을 사용한다면 시간초과가 남.
 * 스택에 넣어서 왼쪽 오른쪽을
 */

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    public static int N;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());

        int[] building = new int[N + 1];
        int[] cnt = new int[N + 1];
        int[] near = new int[N + 1];
        Stack<Integer> stack;

        st = new StringTokenizer(br.readLine());

        Arrays.fill(near, -100_000);
        for (int i=1; i<=N; i++) {
            building[i] = Integer.parseInt(st.nextToken());
        }

        stack = new Stack<>();
        for (int i=1; i<=N; i++) {
            // stack 대비 왼쪽에 있는 값이 보이지 않는 빌딩이라면 제거
            while (!stack.isEmpty() && building[stack.peek()] <= building[i]) {
                stack.pop();
            }
            cnt[i] = stack.size();
            if (cnt[i] > 0) // 스택에 남아있다면 보이는 가까운 빌딩 업데이트
                near[i] = stack.peek();
            stack.push(i);
        }

        stack = new Stack<>();
        for (int i=N; i>0; i--) {
            // stack 대비 오른쪽에 있는 값이 보이지 않는 빌딩이라면 제거
            while (!stack.isEmpty() && building[stack.peek()] <= building[i]) {
                stack.pop();
            }
            cnt[i] += stack.size(); // 카운팅 추가
            // 스택에 남아있고, 해당 빌딩이 기존 보이는 빌딩보다 가깝다면 업데이트
            if (!stack.isEmpty() && stack.peek() - i < i - near[i])
                near[i] = stack.peek();
            stack.push(i);
        }

        for (int i=1; i<=N; i++) {
            sb.append(cnt[i]);
            if (cnt[i] > 0)
                sb.append(" ").append(near[i]);
            sb.append("\n");
        }
        System.out.println(sb);
    }
}