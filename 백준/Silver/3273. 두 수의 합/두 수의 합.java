import java.io.*;
import java.util.*;

/**
 * 시간 제한 1초
 * 메모리 제한 128 MB
 * ---
 * n 개의 수열안에서 2개의 합으로 X를 만들 수 있는 쌍의 수를 구하라
 * (1 ≤ n ≤ 100000, 1 ≤ x ≤ 2000000)
 *
 * ai + aj = x (1 ≤ i < j ≤ n) 를 만족하는 쌍의 수
 * 1. 정렬을 해도 되는가? i < j 조건이 존재하지만 결국 쌍을 구하기에 정렬을 진행
 * 2. 양 끝에서 투포인터 알고리즘을 활용해서 탐색
 * 5 12 7 10 9 1 2 3 11
 * 1 2 3 5 7 9 10 11 12
 *
 */

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    public static int N, x;
    public static int[] ary;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());

        ary = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            ary[i] = Integer.parseInt(st.nextToken());
        }

        x = Integer.parseInt(br.readLine());

        Arrays.sort(ary);

        int left = 0;
        int right = N-1;
        int sum = 0;
        int count = 0;
        while (left < right) {
            sum = ary[left] + ary[right];

            if (sum == x) {
                count++;
            }

            if (sum < x) {
                left++;
            } else {
                right--;
            }


        }
        System.out.println(count);
    }
}
