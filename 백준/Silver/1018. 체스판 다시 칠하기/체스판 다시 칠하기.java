import java.io.*;
import java.util.StringTokenizer;

class Main {
    static boolean[][] check;
    static int result = 64;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        check = new boolean[n][m]; //B=true , W=false

        for(int i=0;i<n;i++){
            String s = br.readLine();
            for(int j=0;j<m;j++) {
                if (s.charAt(j)=='B')
                    check[i][j] = true;
                else {
                    check[i][j] = false;
                }
            }
        }

        for(int i=0;i<n-7;i++){
            for(int j=0;j<m-7;j++){
                test(i,j);
            }
        }
        System.out.println(result);
    }
    public static void test(int x,int y){
        int x_end = x+8;
        int y_end = y+8;
        boolean temp = check[x][y];
        int count=0;

        for(int i=x;i<x_end;i++){
            for(int j=y;j<y_end;j++){
                if(check[i][j] != temp){
                    count++;
                }
                temp = !temp;
            }
            temp = !temp;
        }
        count = Math.min(count,64-count);
        result = Math.min(result,count);
    }
}
