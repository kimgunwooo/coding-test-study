import java.io.*;
import java.util.StringTokenizer;

public class Main {
    //0
    static int white=0;
    //1
    static int blue=0;
    static int[][] paper;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 2, 4, 8, 16, 32, 64, 128 중 하나
        int n = Integer.parseInt(br.readLine());

        paper = new int[n][n];
        for(int i=0;i<n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            for(int j=0;j<n;j++){
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        counter(0,0,n);

        System.out.println(white);
        System.out.println(blue);
    }
    public static void counter(int col,int row,int n){
        int count=0;
        for(int i=col;i<col+n;i++){
            for(int j=row;j<row+n;j++){
                if(paper[i][j] == 1){
                    count++;
                }
            }
        }
        if(count==0){
            white++;
        }
        else if(count==n*n){
            blue++;
        }
        else{
            // 1 2
            // 3 4
            counter(col,row,n/2);
            counter(col+n/2,row,n/2);
            counter(col,row+n/2,n/2);
            counter(col+n/2,row+n/2,n/2);
        }
    }
}