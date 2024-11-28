import java.io.*;
import java.util.*;

/**
 * 시간 제한 1초
 * 메모리 제한 128 MB
 * ---
 * 틱택토
 * 최종 상태가 주어지는데
 * 1. X 승
 *  - X가 O보다 하나 더 많아야 함.
 *  - O로 이루어진 틱택토가 없어야 함.
 *  - X로 이루어진 틱택토 하나
 * 2. O 승
 *  - X와 O의 개수가 같아야 함.
 * 3. 바둑판이 가득 참
 *  - X가 5개 O가 4개
 *  - 틱택토가 하나도 없어야 한다.
 */

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;
    public static int T;

    public static void main(String[] args) throws IOException {
        while (true) {
            String str = br.readLine();
            char[][] map = new char[3][3];

            if (str.equals("end")) {
                break;
            }

            int x = 0;
            int o = 0;
            for (int i=0; i<9; i++) {
                map[i/3][i%3] = str.charAt(i);
                if (str.charAt(i) == 'X') x++;
                else if (str.charAt(i) == 'O') o++;
            }

            if (isXTicTacToe(map) && !isOTicTacToe(map) && x == o+1)
                sb.append("valid").append("\n");
            else if (isOTicTacToe(map) && !isXTicTacToe(map) && x == o)
                sb.append("valid").append("\n");
            else if (!isOTicTacToe(map) && !isXTicTacToe(map) && x == 5 && o == 4)
                sb.append("valid").append("\n");
            else
                sb.append("invalid").append("\n");

        }
        System.out.println(sb);
    }

    public static boolean isXTicTacToe(char[][] map) {
        for (int i=0; i<3; i++) {
            if (map[i][0] == 'X' && map[i][0] == map[i][1] && map[i][1] == map[i][2])
                return true;
            if (map[0][i] == 'X' && map[0][i] == map[1][i] && map[1][i] == map[2][i])
                return true;
        }
        if (map[0][0] == 'X' && map[0][0] == map[1][1] && map[1][1] == map[2][2])
            return true;
        if (map[0][2] == 'X' && map[0][2] == map[1][1] && map[1][1] == map[2][0])
            return true;
        return false;
    }

    public static boolean isOTicTacToe(char[][] map) {
        for (int i=0; i<3; i++) {
            if (map[i][0] == 'O' && map[i][0] == map[i][1] && map[i][1] == map[i][2])
                return true;
            if (map[0][i] == 'O' && map[0][i] == map[1][i] && map[1][i] == map[2][i])
                return true;
        }
        if (map[0][0] == 'O' && map[0][0] == map[1][1] && map[1][1] == map[2][2])
            return true;
        if (map[0][2] == 'O' && map[0][2] == map[1][1] && map[1][1] == map[2][0])
            return true;
        return false;
    }
}