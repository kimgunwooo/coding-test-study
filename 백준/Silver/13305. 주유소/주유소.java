import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine()); // 도시의 수
        int[] roads = new int[n-1]; // 도로의 길이
        int[] prices = new int[n-1]; // 주유소의 리터당 가격
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<n-1;i++) {
            int road = Integer.parseInt(st.nextToken());
            roads[i] = road;
        }
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++) {
            int price = Integer.parseInt(st.nextToken());
            if(i==n-1) continue; // 마지막값은 사용하지 않음.
            prices[i] = price;
        }

        long result = 0;
        int minPrice = prices[0];
        result += (long) minPrice * roads[0];
        for(int i=1;i<n-1;i++) {
            if(minPrice > prices[i])
                minPrice = prices[i];

            result += (long) minPrice * roads[i];
        }

        System.out.println(result);

    }
}
