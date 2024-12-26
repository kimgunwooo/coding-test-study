import java.io.*;
import java.util.*;

/**
 * 시간 제한 2초
 * 메모리 제한 128 MB
 * ---
 * (1 ≤ N ≤ 26)
 * 후위표기식 계산하기
 * ABC*+DE/-
 * A+B*C-D/E
 * 1+6-0.8 = 6.20
 *
 *
 */

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    public static int n;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        String str = br.readLine();

        double[] ary = new double[n];
        for (int i=0; i<n; i++) {
            ary[i] = Double.parseDouble(br.readLine());
        }

        Stack<Double> stack = new Stack<>();

        for (int i=0; i<str.length(); i++) {
            char c = str.charAt(i);

            if (c == '*') {
                double back = stack.pop();
                double front = stack.pop();
                stack.push(front * back);
            } else if (c == '+') {
                double back = stack.pop();
                double front = stack.pop();
                stack.push(front + back);
            } else if (c == '/') {
                double back = stack.pop();
                double front = stack.pop();
                stack.push(front / back);
            } else if (c == '-') {
                double back = stack.pop();
                double front = stack.pop();
                stack.push(front - back);
            } else {
                stack.push(ary[c - 'A']);
            }
        }

        System.out.printf("%.2f", stack.pop());
    }
}