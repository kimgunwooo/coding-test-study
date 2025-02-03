import java.io.*;
import java.util.*;

/*
2초, 512MB
---
유명한 배낭 문제
물건마다 무게와 가치를 가지는데, 가방에 넣을 수 있는 물건의 최대 가치를 구하면 됨

물건을 나눌 수 없기 때문에 DP로 접근해야 한다.
(6 13) (4 8) (3 6) (5 12)

k = 7
i/j 1  2   3   4   5   6   7
1   0   0   0   0   0   13  13
2   0   0   0   8   8   13  13
3   0   0   6   8   8   13  14
4   0   0   6   8   12  13  14

해당 dp 배열은 배낭의 무게가 j 일때 최대 가치를 나타낸 것이다.
우선적으로 각 dp 배열에서 i 일때 담을 수 있는지 없는지 체크.
담을 수 없다면 이전 dp[i-1][j] 의 값을 가져옴.
담을 수 있다면 이전 dp[i-1][j] 의 값과, dp[i-1][j-(i일때 무게)]+(i일때 가치) 의 최대값을 구하면된다.
j=7의 예시로 i=3 일때 Max(13,8+6) = 14 가 나오게 된다.
---
N(1 ≤ N ≤ 100) 물품 수
K(1 ≤ K ≤ 100,000) 배낭 무게
W(1 ≤ W ≤ 100,000) 물건 무게
V(0 ≤ V ≤ 1,000) 물건 가치
*/
class Product implements Comparable<Product>{
    int weight;
    int value;
    public Product (int weight, int value) {
        this.weight = weight;
        this.value = value;
    }
    public int compareTo(Product p) {
        return p.weight - this.weight;
    }
}

public class Main {
    public static int n, k, result;
    public static Product[] products;
    public static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        products = new Product[n+1];
        for (int i=1; i<=n; i++) {
            st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            products[i] = new Product(weight, value);
        }

        dp = new int[k+1];
        for (int i=1; i<=n; i++) {
            for (int j=k; j-products[i].weight >= 0; j--) {
                dp[j] = Math.max(dp[j], dp[j - products[i].weight] + products[i].value);
            }
        }

        System.out.println(dp[k]);
    }
}
