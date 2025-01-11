import java.io.*;
import java.util.*;

/**
 * 시간 제한 1초
 * 메모리 제한 1024 MB
 * ---
 * 규칙
 * 1. 비어있는 칸 중에서 좋아하는 학생이 인접한 칸에 가장 많은 칸으로 자리를 정한다.
 * 2. 1을 만족하는 칸이 여러 개이면, 인접한 칸 중에서 비어있는 칸이 가장 많은 칸으로 자리를 정한다.
 * 3. 2를 만족하는 칸도 여러 개인 경우에는 행의 번호가 가장 작은 칸으로, 그러한 칸도 여러 개이면 열의 번호가 가장 작은 칸으로 자리를 정한다.
 *
 * 3 ≤ N ≤ 20
 */

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    public static int[][] classroom;
    public static Map<Integer, int[]> student;
    public static int[] dx = {1, -1, 0, 0};
    public static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());

        classroom = new int[N][N];
        student = new HashMap<>();

        for (int i = 0; i < N*N; i++) {
            st = new StringTokenizer(br.readLine());
            int studentNum = Integer.parseInt(st.nextToken());
            int s1 = Integer.parseInt(st.nextToken());
            int s2 = Integer.parseInt(st.nextToken());
            int s3 = Integer.parseInt(st.nextToken());
            int s4 = Integer.parseInt(st.nextToken());
            student.put(studentNum, new int[]{s1, s2, s3, s4});
            putStudent(studentNum); // 학생 자리 배치하기
        }

        // 만족도 구하기
        int satisfy = getSatisfy();
        System.out.println(satisfy);
    }

    private static int getSatisfy() {
        int sum = 0;
        for (int i = 0; i < classroom.length; i++) {
            for (int j = 0; j < classroom[i].length; j++) {
                int[] friends = student.get(classroom[i][j]);
                int friendNum = 0;
                for (int k = 0; k < 4; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];
                    if (nx < 0 || ny < 0 || nx >= classroom.length || ny >= classroom.length) continue;
                    for (int f : friends) { // 근처 친구 찾기
                        if (classroom[nx][ny] == f) {
                            friendNum++;
                        }
                    }
                }
                // 조건에 맞게 만족도 할당
                sum += (int) Math.pow(10, friendNum-1);
            }
        }
        return sum;
    }

    private static void putStudent(int studentNum) {
        int[] friends = student.get(studentNum);

        List<int[]> list = new ArrayList<>(); // 정렬에 사용할 리스트
        for (int i = 0; i < classroom.length; i++) {
            for (int j = 0; j < classroom.length; j++) {
                int friendNum = 0;
                int emptySeatNum = 0;
                for (int k = 0; k < 4; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];
                    if (nx < 0 || ny < 0 || nx >= classroom.length || ny >= classroom.length) continue;
                    int cur = classroom[nx][ny];
                    // 해당 좌표가 좋아하는 학생이라면 카운팅
                    if (cur == friends[0] || cur == friends[1] || cur == friends[2] || cur == friends[3]) {
                        friendNum++;
                    }
                    if (cur == 0) { // 해당 좌표가 빈자리라면 카운팅
                        emptySeatNum++;
                    }
                }
                list.add(new int[]{friendNum, emptySeatNum, i, j}); // 정렬할 순서대로 삽입
            }
        }

        // 주어진 조건으로 정렬하기
        Collections.sort(list, (o1, o2) -> {
            if (o1[0] < o2[0]) return 1;
            else if (o1[0] == o2[0]) {
                if (o1[1] < o2[1]) return 1;
                else if (o1[1] == o2[1]) {
                    if (o1[2] > o2[2]) return 1;
                    else if (o1[2] == o2[2]) {
                        if (o1[3] > o2[3]) return 1;
                    }
                }
            }
            return -1;
        });

        for (int[] l : list) {
            if (classroom[l[2]][l[3]] == 0) {
                classroom[l[2]][l[3]] = studentNum;
                return;
            }
        }
    }
}
