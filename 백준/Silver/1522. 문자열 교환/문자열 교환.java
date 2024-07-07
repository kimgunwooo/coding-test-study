import java.io.*;
import java.util.*;

/**
 * 1 ≤ str ≤ 1,000
 * 문자열이 원형으로 이어진다고 생각하고, a, b를 연속으로 되게 만드는 문제
 * 시간제한이 2초, 메모리도 넉넉하다.
 * a, b 를 직접 교환하는 것을 생각하는게 아니라, a의 최종 길이를 window 길이로 둔다.
 * 그리고 그 window 안에 b의 개수의 최소를 구하면 된다.
 * 해결은 간단한데, 생각하기가 힘든 것 같다.
 */

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        String str = br.readLine();

        System.out.println(solution(str));
    }

    private static int solution(String str) {
        int aCount = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'a')
                aCount++;
        }

        for (int i = 0; i < str.length(); i++) {
            int bCount = 0;
            for (int j = i; j < i + aCount; j++) {
                if (str.charAt(j % str.length()) == 'b')
                    bCount++;
            }
            min = Math.min(min, bCount);
        }

        return min;
    }
}