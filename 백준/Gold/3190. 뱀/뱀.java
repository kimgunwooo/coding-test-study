import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static int[][] board;
    static Map<Integer,String> moveInfo = new HashMap<>();

    // 우(시작), 하(D-우측회전, index++), 좌(D-우측회전, index++), 상(D-우측회전, index++)
    static int index=0;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        board = new int[n+1][n+1];

        //사과의 위치
        for(int i=0;i<k;i++){
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            board[a][b] = 1;
        }

        int l = Integer.parseInt(br.readLine());
        //시간,방향 저장
        for(int i=0;i<l;i++){
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            String c = st.nextToken();
            moveInfo.put(x,c);
        }

        int result = solve();
        System.out.println(result);
    }
    static int solve(){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{1,1});
        int time = 0;
        int px =1;
        int py =1;
        while(true){
            int mx = px + dx[index];
            int my = py + dy[index];
            time++;

            //벽에 부딪힘.
            if(mx < 1 || my < 1 || mx > n || my > n){
                return time;
            }
            int[] temp = {mx,my};
            //자기 몸에 부딪힘.
            for (int[] body : queue) {
                if(body[0]==mx && body[1]==my){
                    return time;
                }
            }

            //이동
            queue.add(new int[]{mx,my});

            //사과가 있다면
            if(board[my][mx] == 1){
                board[my][mx] = 0;
            } else{ //사과가 없다면
                queue.remove();
            }

            //방향 변경 확인
            if(moveInfo.containsKey(time)){
                String direction = moveInfo.get(time);
                if(direction.equals("L")){
                    index--;
                    if(index == -1){
                        index = 3;
                    }
                }
                else if(direction.equals("D")){
                    index++;
                    if(index == 4){
                        index = 0;
                    }
                }
            }

            px = mx;
            py = my;
        }
    }
}