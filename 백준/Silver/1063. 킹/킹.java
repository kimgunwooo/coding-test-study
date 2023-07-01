import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        char[] king = st.nextToken().toCharArray();
        int kingX = king[0] - 'A'+1;
        int kingY = king[1] - '0';
        char[] stone = st.nextToken().toCharArray();
        int stoneX = stone[0] - 'A'+1;
        int stoneY = stone[1] - '0';
        int n = Integer.parseInt(st.nextToken());

        // R L T B RT RB LT LB
        int[] dx = {1,-1,0,0,1,1,-1,-1};
        int[] dy = {0,0,1,-1,1,-1,1,-1};

        for(int i=0;i<n;i++){
            String dm = br.readLine();
            int index = 0;
            switch (dm) {
                case "R" : index=0; break;
                case "L" : index=1; break;
                case "T" : index=2; break;
                case "B" : index=3; break;
                case "RT" : index=4; break;
                case "RB" : index=5; break;
                case "LT" : index=6; break;
                case "LB" : index=7; break;
            };
            int tX = kingX + dx[index];
            int tY = kingY + dy[index];

            if(tX>=1 && tX<=8 && tY>=1 && tY<=8){
                if(stoneX == tX && stoneY == tY){
                    int stX = stoneX + dx[index];
                    int stY = stoneY + dy[index];
                    if(stX>=1 && stX<=8 && stY>=1 && stY<=8){
                        stoneX += dx[index];
                        stoneY += dy[index];
                    }
                    else continue;
                }
                kingX = tX;
                kingY = tY;
            }
        }
        System.out.println((Character.toString(kingX+'A'-1)) + (kingY));
        System.out.println((Character.toString(stoneX+'A'-1)) + (stoneY));
    }
}