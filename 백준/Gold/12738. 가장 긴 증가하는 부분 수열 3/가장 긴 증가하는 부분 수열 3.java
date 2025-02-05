import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
1초 / 512MB
---
가장 긴 증가하는 부분 수열 2

LIS 문제이다.

기존 방법으로 접근하면 O(N^2)로 시간초과가 나게된다.
그렇기 때문에 LIS 와 이분탐색 개념을 섞어서 해결해야 한다.

LIS 문제의 중점은 증가와 가장 긴 경우를 구해야한다.

주요 해결 로직은
1. arr[0] 을 넣고 시작
2. 다음 값부터 arr 배열에서 탐색을 진행한다.
    - 마지막 값보다 클 경우 추가한다.
    - 마지막에 넣을 수 없다면 넣을 자리를 찾아야 하기에 이분 탐색 진행
        - 넣을 자리를 찾았다면 삽입이 아닌 '대치'를 해야함.

반복.

---
N (1 ≤ N ≤ 1,000,000)

 */

public class Main {
    public static int[] LIS, arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());


        StringTokenizer st = new StringTokenizer(br.readLine());
        LIS = new int[N];
        arr = new int[N];
        for (int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        LIS[0] = arr[0]; // 초기 값 설정
        int lengthOfLIS = 1;

        for (int i=1; i<N; i++) {
            int key = arr[i];

            // 마지막값보다 크다면 배열 마지막에 추가
            if (LIS[lengthOfLIS-1] < key) {
                LIS[lengthOfLIS++] = key;
            }
            else { // 이분탐색을 진행한다.
                int low = 0;
                int high = lengthOfLIS;

                while (low < high) {
                    int mid = (low + high)/2;
                    if (LIS[mid] < key) {
                        low = mid + 1;
                    } else {
                        high = mid;
                    }
                }
                LIS[low] = key;
            }
        }
        System.out.println(lengthOfLIS);
    }
}
