import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
1초 / 128MB
---
주차 빌딩
엘리베이터 층 이동시 10초
컨테이어 벨트가 한 대 만큼 이동 5초

정수가 -1인 경우에는 그 칸이 비어있는 곳이고
다른 값인 r인 경우에는 r번째 손님이 찾아가는 차
1층에서 찾아가고, 엘리베이터는 첫 번째 위치에 있다. 엘리베이터는 처음에 항상 비어있다.
원형으로 이루어져있음을 생각

50개 숫자로 50x50 배열을 매번 돌면 125,000
이를 100번 12,500,000
즉, brute force 가능
---
TC <= 100
(1 ≤ h ≤ 50, 2 ≤ l ≤ 50)
 */
public class Main {
    static int T;
    static int h, l;
    static int[][] parkingBuilding = new int[50][50];
    static int[] tempFloor = new int[50];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            h = Integer.parseInt(st.nextToken());
            l = Integer.parseInt(st.nextToken());

            for (int j = 0; j < h; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < l; k++) {
                    parkingBuilding[j][k] = Integer.parseInt(st.nextToken());
                }
            }

            sb.append(solution()).append("\n");
        }
        System.out.print(sb);
    }

    static int solution() {
        int curNum = 1;
        int answer = 0;

        while (true) {
            boolean isFound = false;
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < l; j++) {
                    if (curNum == parkingBuilding[i][j]) {
                        answer += i * 2 * 10; // 층 수에 따른 엘리베이터 왕복 시간
                        isFound = true;

                        // 0 위치에서 가까운 쪽으로 값 업데이트
                        if (j <= l / 2) {
                            answer += j * 5;
                        } else {
                            answer += (l - j) * 5;
                        }

                        // 해당 층의 컨베이어 회전
                        for (int k = 0; k < l; k++) {
                            tempFloor[(k + l - j) % l] = parkingBuilding[i][k];
                        }
                        for (int k = 0; k < l; k++) {
                            parkingBuilding[i][k] = tempFloor[k];
                        }
                    }
                }
                if (isFound) break; // 찾았다면 추가 탐색은 불필요하므로 종료
            }

            if (!isFound) break; // 존재하는 모든 차량을 돌았다면 종료
            curNum++;
        }

        return answer;
    }
}