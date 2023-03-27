import java.io.*;
import java.util.StringTokenizer;
import java.util.Scanner;
class Main {

    static int[][] dp= new int[30][30];

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<t;i++){
            st = new StringTokenizer(br.readLine()," ");
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            //bw.write(combination(n,m)+"\n");
            //bw.flush();
            sb.append(combination(m, n)).append('\n');
        }
        System.out.println(sb);
        //bw.close();
    }
    public static int combination(int n,int r){
        if (dp[n][r] > 0) {
            return dp[n][r];
        }
        if (r == 0 || n == r) {
            return dp[n][r] = 1;
        }

        return dp[n][r]= combination(n - 1, r - 1) + combination(n - 1, r);
    }
}
