import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine()); // 굴다리의 길이
        int m = Integer.parseInt(br.readLine()); // 가로등의 개수

        Stack<Integer> stack = new Stack<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<m;i++) {
            int x = Integer.parseInt(st.nextToken());
            stack.push(x);
        }

        // 가로등이 하나라면, 시작과 끝중 멀리있는 곳 까지의 길이 중, 최대 길이를 반환
        if(m==1) {
            int pos = stack.pop();
            System.out.println(Math.max(pos, n-pos));
            return;
        }

        /**
         * 가로등이 2개 이상이라면?
         * 첫 가로등까지의 길이, 가로등 사이 가장 큰 길이, 마지막 가로등에서 끝까지 길이
         * 를 비교해서 최소 높이를 구한다.
         */
        int prev = stack.pop();
        int max = Integer.MIN_VALUE;

        int last = n - prev; // 마지막 가로등에서 끝까지 길이
        while(!stack.isEmpty()) {
            int next = stack.pop();
            max = Math.max(max, Math.abs(next-prev));
            prev = next;
        }
        int betMax = (int) Math.ceil((double) max/2);
        int first = prev; // 첫 가로등까지의 길이

        int result = Math.max(last,betMax);
        result = Math.max(result, first);

        System.out.println(result);
    }
}
