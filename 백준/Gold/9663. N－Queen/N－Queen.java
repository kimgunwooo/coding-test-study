import java.io.*;

public class Main {
    static int N;
    static int[] chess;
    static int count=0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        chess = new int[N];

        n_Queen(0);
        System.out.println(count);
    }
    public static void n_Queen(int depth){
        //모든 퀸을 배치했다면
        if(depth == N){
            count++;
            return;
        }

        for(int i=0;i<N;i++){
            chess[depth]=i;
            if(check(depth)){
                n_Queen(depth+1);
            }
        }
    }
    public static boolean check(int col){
        for(int i=0;i<col;i++){
            //해당 열의 행과 i열의 행 비교 (같은 행에 존재하는지)
            if(chess[col] == chess[i])
                return false;

            //열 끼리의 차와 행 끼리의 차가 같은 경우 (대각선 상에 존재하는지)
            else if(Math.abs(col-i) == Math.abs(chess[col]-chess[i]))
                return false;
        }
        return true;
    }
}