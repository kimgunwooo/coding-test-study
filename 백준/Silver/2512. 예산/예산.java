import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int[] budget = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for(int i=0;i<n;i++) {
            budget[i] = Integer.parseInt(st.nextToken());
        }
        int m = Integer.parseInt(br.readLine());

        Arrays.sort(budget);

        if(Arrays.stream(budget).sum() < m) {
            System.out.println(budget[n-1]);
            return;
        }

        int left = 1;
        int right = budget[n-1];
        int boundary = 0;
        while(left <= right) {
            int mid = (left + right) / 2;

            // 정수 상한액을 기준으로 비교해서 계산
            int sum = 0;
            for(int i=0;i<n;i++) {
                if(budget[i] < mid)
                    sum += budget[i];
                else
                    sum += mid;
            }

            if(sum <= m) {
                boundary = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(boundary);
    }
}
