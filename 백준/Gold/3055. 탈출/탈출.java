import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int r,c;
    static char[][] map;
    static Queue<int[]> sq = new LinkedList<>();
    static Queue<int[]> wq = new LinkedList<>();
    public static int[] dx = {0, 0, -1, 1};
    public static int[] dy = {1, -1, 0, 0};
    static int count = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        // 맵 구성
        map = new char[r][c];
        for(int i=0;i<r;i++) {
            String str = br.readLine();
            for(int j=0;j<c;j++) {
                map[i][j] = str.charAt(j);

                if(map[i][j] == 'S') {
                    sq.add(new int[]{i,j,0});
                } else if(map[i][j] == '*') {
                    wq.add(new int[]{i,j});
                }
            }
        }

        bfs();
        System.out.println(count == Integer.MAX_VALUE ? "KAKTUS" : count);
    }

    private static void bfs() {
        while( !sq.isEmpty() ) {
            // 물 이동
            int w_len = wq.size();
            for( int i=0; i<w_len; i++ ) {
                int[] cur_w = wq.poll();

                for( int j=0; j<4; j++ ) {
                    int nx = cur_w[0] + dx[j];
                    int ny = cur_w[1] + dy[j];
                    if( nx>=0 && nx<r && ny>=0 && ny<c && map[nx][ny]=='.' ) {
                        map[nx][ny] = '*'; // 확장
                        wq.add( new int[] { nx, ny } ); // 다음 이동 좌표 저장
                    }
                }
            }

            // 고슴도치 이동
            int s_len = sq.size();
            for( int i=0; i<s_len; i++ ) {
                int[] cur_s = sq.poll();

                for( int j=0; j<4; j++ ) {
                    int nx = cur_s[0] + dx[j];
                    int ny = cur_s[1] + dy[j];
                    int time = cur_s[2];
                    if( nx>=0 && nx<r && ny>=0 && ny<c ) {
                        if( map[nx][ny] == 'D' ) {
                            count = Math.min( count, time+1 );
                            return;
                        }
                        else if( map[nx][ny] == '.' ) {
                            map[nx][ny] = 'S';
                            sq.add( new int[] { nx, ny, time+1 } );
                        }
                    }
                }
            }
        }
    }
}
