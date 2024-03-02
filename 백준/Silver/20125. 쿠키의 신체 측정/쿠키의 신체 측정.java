import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static char[][] map;
    static int hx, hy;
    static int la, ra, wa, ll, rl;
    static int wax, way;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        map = new char[n+1][n+1];

        for(int i=1;i<=n;i++) {
            String str = br.readLine();
            for(int j=1;j<=n;j++) {
                map[i][j] = str.charAt(j-1);
            }
        }

        findHeart();

        findBodyLength();

        System.out.println(hx + " " + hy);
        System.out.println(la + " " + ra + " " + wa + " " + ll + " " + rl);
    }

    private static void findHeart() {
        for(int i=2;i<map.length-1;i++) {
            for(int j=2;j<map.length-1;j++) {
                if(map[i-1][j] == '*' && map[i][j-1] == '*' && map[i+1][j] == '*' && map[i][j+1] == '*') {
                    hx = i;
                    hy = j;
                }
            }
        }
    }

    private static void findBodyLength() {
        // 왼팔 찾기
        for(int i=hy-1;i>0;i--) {
            if(map[hx][i] == '*')
                la++;
            else
                break;
        }

        // 오른팔 찾기
        for(int i=hy+1;i<map.length;i++) {
            if(map[hx][i] == '*')
                ra++;
        }

        // 허리 찾기
        for(int i=hx+1;i<map.length;i++) {
            if(map[i][hy] == '*')
                wa++;
            else {
                wax = i-1;
                way = hy;
                break;
            }
        }

        // 왼다리 찾기
        for(int i=wax+1;i<map.length;i++) {
            if(map[i][way-1] == '*')
                ll++;
            else
                break;
        }

        // 오른 찾기
        for(int i=wax+1;i<map.length;i++) {
            if(map[i][way+1] == '*')
                rl++;
            else
                break;
        }
    }
}



