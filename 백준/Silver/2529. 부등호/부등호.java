import java.io.*;
import java.util.*;

/**
 * 시간 제한 1초
 * 메모리 제한 256 MB
 * ---
 * 2 ≤ k ≤ 9
 * 부등호 관계를 만족하는 k+1 자리의 최대, 최소 정수를 출력
 */

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    public static int k;
    public static boolean[] visitied = new boolean[10];
    public static char[] sign;
    public static List<String> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        k = Integer.parseInt(br.readLine());
        sign = new char[k];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            sign[i] = st.nextToken().charAt(0);
        }

        dfs("", 0);
        // 작은 순서대로 모든 경우를 탐색해서 대입했기에 순서대로 저장되어있음.
        System.out.println(list.get(list.size() - 1));
        System.out.println(list.get(0));
    }

    private static void dfs(String num, int idx) {
        if (idx == k+1) {
            list.add(num); // 작은거 순서대로 저장됨
            return;
        }
        for (int i=0; i<10; i++) { // 0~9까지 수
            if (visitied[i]) continue; // 사용한 숫자인지 체크

            // 첫 인덱스라면 통과
            // 이전 숫자와, 다음에 들어갈 숫자, 그리고 그 사이 부등호와의 관계를 체크
            if (idx == 0 || check(num.charAt(idx-1) - '0', sign[idx - 1], i)){
                visitied[i] = true;
                dfs(num+i, idx+1); // 조건에 만족한다면 숫자를 추가
                visitied[i] = false; // 백트래킹
            }
        }
    }

    // 부등호가 성립된다면 true
    private static boolean check(int prev, char c, int next) {
        if (c == '>') {
            return prev > next;
        } else {
            return prev < next;
        }
    }
}
