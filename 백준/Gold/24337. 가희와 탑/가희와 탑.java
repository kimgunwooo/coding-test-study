import java.io.*;
import java.util.*;

/**
 * 시간 제한 1초
 * 메모리 제한 512 MB
 * ---
 * 빌딩의 개수, 왼쪽에서 보이는 빌딩 수, 오른쪽에서 보이는 빌딩 수
 * 1 ≤ N ≤ 100000
 * 1 ≤ a ≤ N
 * 1 ≤ b ≤ N
 *
 * 중간에 가장 큰 높이의 빌딩이 무조건 하나는 존재함.
 * 5 2 처럼 왼쪽이 보이는게 많다면 123451 처럼 구성
 * 3 6 처럼 오른쪽이 보이는게 많다면 12654321 처럼 구성
 * 3 3 처럼 왼쪽 오른쪽이 같다면 12321 처럼 구성됨.
 * 즉, a b 중에 많은것을 골라서 a라면 1~a 까지 오름차순으로 구성한 뒤, b-1부터 1까지 내림차순으로 구성
 * , b라면 1~a-1 까지 오름차순으로 구성한 뒤, b~1 까지 내림차순으로 구성한다.
 * 만약 같다면 1~a~1 까지 계산식 구성
 */

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    public static int N, a, b;
    public static List<Integer> list;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        list = new ArrayList<>();

        if (a+b > N+1) {
            System.out.println(-1);
            return;
        }

        // 1 ~ a-1 까지는 추가
        for (int i=1; i<a; i++) {
            list.add(i);
        }
        // 가장 큰 빌딩은 a,b 중에 큰 값
        list.add(Math.max(a, b));

        // b-1 ~ 1 까지 값 설정
        for (int i=b-1; i>0; i--) {
            list.add(i);
        }

        // 빌딩 개수 맞추기 (사전순으로 정렬이기에 가장 작은 값인 1로 개수를 맞춰줌)
        if (a == 1) { // a==1 이라면 가장 큰 빌딩이 가장 왼쪽에 맞춰져야 하기에 인덱스 1번에 삽입
            while (list.size() < N) {
                list.add(1,1);
            }
        } else { // a!=1 이라면 왼쪽에서 보이는 빌딩의 개수는 변함없기에 제일 앞단에 추가
            while (list.size() < N) {
                list.add(0,1);
            }
        }

        for (int n : list) {
            System.out.print(n + " ");
        }
    }
}