import java.io.*;
import java.util.*;

/**
 * 시간 제한 0.4초
 * 메모리 제한 256 MB
 * ---
 * LCS (Longest Common Subsequence, 최장 공통 부분 수열) 찾기
 * ex) ACAYKP, CAPCAK -> ACAK
 * ---
 * 대문자로만 이루어짐, 최대 1000글자
 * ---
 *   A C A Y K P
 * C 0 1 1 1 1 1
 * A 1* 1 2 2 2 2
 * P 1* 1 2 2 2 3
 * C 1 2* 2 2 2 3
 * A 1 2 3* 3* 3 3
 * K 1 2 3 3 4* 4*
 * 최대값 = 4
 * 배열을 순회하면서
 * 같다면 이전 dp 배열 값 i-1, j-1의 +1
 * 다르다면 이전 열과 이전 행중 큰 값으로 갱신
 */

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    public static char[] str1, str2;

    public static void main(String[] args) throws IOException {
        str1 = br.readLine().toCharArray();
        str2 = br.readLine().toCharArray();

        int[][] lcs = new int[str1.length+1][str2.length+1];

        for (int i = 1; i <= str1.length; i++) {
            for (int j = 1; j <= str2.length; j++) {
                if (str1[i-1] == str2[j-1]) {
                    lcs[i][j] = lcs[i-1][j-1] + 1;
                } else {
                    lcs[i][j] = Math.max(lcs[i-1][j], lcs[i][j-1]);
                }
            }
        }
        System.out.println(lcs[str1.length][str2.length]);
    }
}
