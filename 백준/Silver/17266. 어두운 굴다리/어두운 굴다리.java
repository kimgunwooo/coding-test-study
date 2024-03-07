import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine()); // 굴다리의 길이
        int m = Integer.parseInt(br.readLine()); // 가로등의 개수

        int[] streetLamps = new int[m];
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for (int i = 0; i < m; i++) {
            streetLamps[i] = Integer.parseInt(st.nextToken());
        }

        int left = 1; // 굴다리 최소 길이
        int right = n; // 굴다리 최대 길이
        int result = 0; // 최소 높이
        while(left <= right) {
            int mid = (left + right) / 2;
            boolean flag = true; // 모든 가로등을 이용해 굴다리를 비출 수 있는지 여부

            int prev = 0; // 이전 가로등이 비춘 마지막 시점
            for(int i=0;i<streetLamps.length;i++) { // 모든 가로등이 현재 높이에서 굴다리를 비출 수 있는지 검사
                /**
                 * 해당 가로등이 비출 수 있는 최소값이 이전 가로등이 비춘 마지막 시점보다 작다면 이전값을 다시 업데이트해준다.
                 * (= 가로등이 빈곳없이 다 비추는지 검사)
                 */
                if (streetLamps[i] - mid <= prev) {
                    prev = streetLamps[i] + mid; // 가로등이 다시 비춰야만 하는 최소값 리턴
                } else {
                    flag = false;
                    break;
                }
            }

            /**
             * 마지막 가로등이 길의 마지막까지 비출 수 있는지 체크
             * 마지막 가로등이 비출 수 있는 끝 지점에서 굴다리의 끝 좌표를 뺐을때 0보다 크다면 비추지 못함.
             */
            if(n - prev > 0) flag = false;

            if(flag) { // 높이를 낮춰 더 최적인 높이를 찾기위해 조절
                result = mid;
                right = mid - 1;
            } else { // 높이를 더 늘려 가능한 높이를 찾기위해 조절
                left = mid + 1;
            }
        }

        System.out.println(result);
    }
}
