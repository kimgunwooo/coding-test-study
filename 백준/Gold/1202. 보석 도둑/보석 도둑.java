import java.io.*;
import java.util.*;

/**
 * 시간 제한 1초
 * 메모리 제한 256 MB
 * ---
 * (1 ≤ N, K ≤ 300,000)
 * (0 ≤ Mi, Vi ≤ 1,000,000)
 * (1 ≤ Ci ≤ 100,000,000)
 *
 * 가방에는 한개의 보석.
 * 가방의 최대 무게에 가장 가까우면서 가치가 가장 높은걸 선택해야함.
 *
 * 가방은 최대 무게 오름차순 정렬
 * 보석은 무게를 기준으로 오름차순, 무게가 같다면 가치를 기준으로 내림차순
 *
 * 3 65
 * 5 23
 * 2 99
 * 10
 * 2
 *
 * 가치가 높은거 순서대로 가장 최적의 가방에 대입?
 * PriorityQueue 를 사용해서 해당 가방에 넣을 수 있는 무게를 가진 보석들을 모두 삽입
 * 가치에 따른 내림차순으로 정렬이 됨.
 * 만약 존재한다면 poll 했을 때, 가장 큰 값이 됨.
 */

class Jewel implements Comparable<Jewel> {
    int weight;
    int value;

    public Jewel(int weight, int value) {
        this.value = value;
        this.weight = weight;
    }

    public int compareTo (Jewel jewel) {
        if (this.weight == jewel.weight) {
            return jewel.value - this.value;
        }
        return this.weight - jewel.weight;
    }
}

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    public static int N, K;
    public static int[] bags;
    public static Jewel[] jewels;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 보석의 개수
        K = Integer.parseInt(st.nextToken()); // 가방의 개수

        jewels = new Jewel[N];
        bags = new int[K];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken()); // 무게
            int V = Integer.parseInt(st.nextToken()); // 가격
            jewels[i] = new Jewel(M, V);
        }

        for (int i = 0; i < K; i++) {
            bags[i] =  Integer.parseInt(br.readLine());
        }

        Arrays.sort(bags); // 가방을 최대 무게 기준으로 오름차순 정렬
        Arrays.sort(jewels);
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

        long result = 0;
        for (int i = 0, j = 0; i < K; i++) {
            while (j < N) { // 모든 보석들에 대해
                if (bags[i] < jewels[j].weight) break; // 최대무게보다 무거워진다면 종료
                pq.add(jewels[j++].value); // 최대무게보다 작다면 pq에 추가
            }

            if (!pq.isEmpty()) { // 비지않았다면 맨 앞에 가장 적절한 보석의 가치만 제거
                result += pq.poll();
            }
        }

        System.out.println(result);
    }
}