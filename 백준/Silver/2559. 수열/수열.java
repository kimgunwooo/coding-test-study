import java.io.*;
import java.util.*;

/*
1초, 128MB
---
주어진 배열 내에서 가장 큰 합을 가지는 수열 구하기 문제
N은 2 이상 100,000 이하 며, K는 1<=K<=N 으로
완전탐색으로 인한 2중 for문 사용은 불가능하다.

해결 방안은 K 크기의 윈도우를 한칸 씩 움직이면서 최대 크기일 때 업데이트 해주면 된다.
K=1, N=100,000 인 최악의 경우에도 1초를 넘지 않는다.
---
*/

public class Main {
    public static int n, k, result;
    public static int[] numbers;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        numbers = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        int result = Integer.MIN_VALUE;

        // 윈도우 초기화
        int window = 0;
        for (int i=0; i<k; i++) {
            window += numbers[i];
        }

        result = Math.max(result, window);
        int left = 0;
        for (int i=k; i<n; i++) {
            window += numbers[i];
            window -= numbers[left++];
            result = Math.max(result, window);
        }

        System.out.println(result);
    }
}
