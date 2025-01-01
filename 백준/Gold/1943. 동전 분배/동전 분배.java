import java.io.*;
import java.util.*;

/**
 * 시간 제한 2초
 * 메모리 제한 128 MB
 * ---
 * N(1 ≤ N ≤ 100)
 * 입력은 총 3번
 *
 * 동전 개수 쌍으로 주어짐
 * 비싼거부터 차례대로 정렬해서 A, B 두명에게 하나씩 할당
 * 매번 비교해서 작은쪽에다가 꺼내서 더해주면 될듯?
 *
 * 역시 반례가 존재 [2, 2, 3, 4, 5] 일때 구분하지 못함.
 *
 *
 */

class Coin {
    int value;
    int amount;
    public Coin(int value, int amount) {
        this.value = value;
        this.amount = amount;
    }
}

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    public static int N;
    public static Coin[] coins;
    public static boolean[][] dp;

    public static void main(String[] args) throws IOException {

        for (int tc=0; tc<3; tc++) {
            N = Integer.parseInt(br.readLine());
            coins = new Coin[N];
            int sum = 0;

            for (int i=0; i<N; i++) {
                st = new StringTokenizer(br.readLine());
                int value = Integer.parseInt(st.nextToken());
                int amount = Integer.parseInt(st.nextToken());
                coins[i] = new Coin(value, amount);
                sum += value * amount;
            }

            if (sum % 2 == 1) { // 홀수라면 2로 정확히 나눌 수 없음.
                System.out.println(0);
            } else {
                sum /= 2; // 목표 동전 가치를 낮추기위해 /2 진행
                dp = new boolean[N+1][sum+1];
                dp[0][0] = true; // 동전을 사용하지 않고, 0을 만들 수 있음.
                for (int i=1; i<=N; i++) {
                    Coin cur = coins[i-1];
                    for (int j=0; j<=sum; j++) {
                        if (dp[i-1][j]) { // 이전 동전들로 j의 합을 만들 수 있다면
                            for (int k=0; k<=cur.amount; k++) {
                                int temp = j + cur.value * k;
                                if (temp <= sum) {
                                    dp[i][temp] = true;
                                }
                            }
                        }
                    }
                }
                if (dp[N][sum]) {
                    System.out.println(1);
                } else {
                    System.out.println(0);
                }
            }
        }
    }
}