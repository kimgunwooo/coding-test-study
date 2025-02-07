import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
2초 / 1024MB
---
경매
고객사가 최적의 가격으로 광고지면을 구매
입찰 데이터를 분석하여, 입찰 가격 결정 로직을 개선

입찰가 A[] 와 최고 입찰가 B[]
A[] + X 올렸을 때, K개 이상의 낙찰받게 되는 가장 작은 음수 아닌 정수 X 찾기
같을경우도 낙찰

즉, a>=b 경우가 K개 이상 존재해야 하며,
a<b 경우에 그 차이를 저장해놨다가 K 보다 부족할때 꺼내서 확인

---
1 <= K <= N <= 100,000
A,B <= 1,000,000,000
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        List<Integer> list = new ArrayList<>();
        int count = 0;
        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (a >= b) count++;
            else list.add(b-a);
        }

        if (count >= k) {
            System.out.println(0);
        } else {
            Collections.sort(list);
            System.out.println(list.get(k-count-1));
        }
    }
}