import java.io.*;
import java.util.*;

/**
 * 시간 제한 2초
 * 메모리 제한 128 MB
 * ---
 * index 0부터 보이는지 여/부를 체크해서 제일 많이 보이는 빌딩을 선택.
 */

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    public static int N;
    public static int[] building, result;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());

        building = new int[N];
        result = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            building[i] = Integer.parseInt(st.nextToken());
        }

        for (int i=0; i<N-1; i++) {
            result[i]++; // 오른쪽에 있는 건물은 무조건 보임
            result[i+1]++; // 오른쪽에 있는 건물 입장에서 해당 건물이 보임

            double gradient = (building[i+1] - building[i]); // 바로 다음 건물과의 기울기
            for (int j=i+2; j<N; j++) {
                double nextGradient = (double) (building[j] - building[i]) / (j - i);
                if (gradient < nextGradient) { // 다음 기울기가 커야 보임
                    gradient = nextGradient;
                    result[i]++;
                    result[j]++;
                }
            }
        }

        int max = 0;
        for (int i : result) {
            max = Math.max(max, i);
        }
        System.out.println(max);
    }
}