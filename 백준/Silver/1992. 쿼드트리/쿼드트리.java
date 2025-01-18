import java.io.*;
import java.util.*;

/**
 * 시간 제한 2초
 * 메모리 제한 128 MB
 * ---
 * 11 11 00 00
 * 11 11 00 00
 *
 * 00 0 1 11 00
 *
 * 00 0 1 11 00
 *
 * 11 11 00 00
 * 11 11 00 00
 *
 * 11 11 00 11
 * 11 11 00 11
 *
 * 1 ≤ N ≤ 64
 * 쿼드 트리 : 자식 노드가 4개인 트리
 */

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    public static int N;
    public static int[][] matrix;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());

        matrix = new int[N][N];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                matrix[i][j] = str.charAt(j) - '0';
            }
        }

        QuadTree(0, 0, N);
        System.out.println(sb);
    }

    private static void QuadTree(int x, int y, int size) {
        // 압축이 가능한 경우 하나의 색상으로 압축
        if (check(x, y, size)) {
            sb.append(matrix[x][y]);
            return;
        }

        // 압축이 불가능한 경우 추가로 탐색
        int newSize = size / 2;

        sb.append("("); // 각 레벨에서 여는 괄호로 시작

        QuadTree(x, y, newSize); // 왼쪽 위
        QuadTree(x, y+newSize, newSize); // 오른쪽 위
        QuadTree(x+newSize, y, newSize); // 왼쪽 아래
        QuadTree(x+newSize, y+newSize, newSize); // 오른쪽 아래

        sb.append(")"); // 해당 레벨이 끝나면 괄호를 닫기
    }

    private static boolean check(int x, int y, int size) {
        int temp = matrix[x][y];
        for (int i=x; i<x+size; i++) {
            for (int j=y; j<y+size; j++) {
                if (matrix[i][j] != temp) {
                    return false;
                }
            }
        }
        return true;
    }
}
