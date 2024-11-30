import java.io.*;
import java.util.*;

/**
 * 시간 제한 1초
 * 메모리 제한 512 MB
 * ---
 * N, K, P, X
 * N : 총 층 <= 10^6
 * K : 자리의 수 <= 6
 * P : 반전시킬 수 <= 42
 * X : 주어진 층 <= N
 */

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;
    public static int T;

    public static int[][] numbers = {
            {1, 1, 1, 0, 1, 1, 1}, // 0
            {0, 0, 1, 0, 0, 1, 0}, // 1
            {1, 0, 1, 1, 1, 0, 1}, // 2
            {1, 0, 1, 1, 0, 1, 1}, // 3
            {0, 1, 1, 1, 0, 1, 0}, // 4
            {1, 1, 0, 1, 0, 1, 1}, // 5
            {1, 1, 0, 1, 1, 1, 1}, // 6
            {1, 0, 1, 0, 0, 1, 0}, // 7
            {1, 1, 1, 1, 1, 1, 1}, // 8
            {1, 1, 1, 1, 0, 1, 1}, // 9
    };
    public static int N, K, P, X;


    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        int[] floor = convertToIntAry(X);

        int count = 0;
        for (int i=1; i<=N; i++) {
            if (i == X) continue;
            if (checkReverse(i, floor)) count++;
        }
        System.out.println(count);
    }

    private static boolean checkReverse(int target, int[] intAry) {
        int[] targetAry = convertToIntAry(target);

        int count = 0;
        for (int i=0; i<K; i++) {
            for (int j=0; j<7; j++) {
                if (numbers[targetAry[i]][j] != numbers[intAry[i]][j]) {
                    count++;
                    if (count > P) return false;
                }
            }
        }
        return true;
    }

    public static int[] convertToIntAry(int x) {
        int[] temp = new int[K];
        for (int i=K-1; i>=0; i--) {
            temp[i] = x % 10;
            x /= 10;
        }
        return temp;
    }
}