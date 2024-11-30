import java.io.*;
import java.util.*;

/**
 * 시간 제한 1초
 * 메모리 제한 128 MB
 * ---
 * 1~N 까지의 수열이 주어졌을 때,
 * +, -, " " 을 삽입해서 그 결과가 0이 될 수 있는지 확인
 * 최대 9가지 테스트
 * 3 <= N <= 9
 * 9라면 삽입 가능한 곳이 8개
 * 3^8 브루트포스로 접근 가능
 */

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;
    public static int N;

    public static void main(String[] args) throws IOException {
        int testCase = Integer.parseInt(br.readLine()); // < 10

        for (int i=1; i<=testCase; i++) {
            N = Integer.parseInt(br.readLine()); // 3 <= <= 9
            findAllExpression(1, 1, 0, 1, "1");
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static void findAllExpression(int idx, int n, int sum, int op, String expression) {
        if (idx == N) {
            sum += n * op; // 마지막 연산 처리
            if (sum == 0) sb.append(expression).append("\n");
            return;
        }

        findAllExpression(idx+1, (n*10)+(idx+1), sum, op, expression + " " + (idx+1));
        findAllExpression(idx+1, idx+1, sum+(n*op), 1, expression + "+" + (idx+1));
        findAllExpression(idx+1, idx+1, sum+(n*op), -1, expression + "-" + (idx+1));
    }

}