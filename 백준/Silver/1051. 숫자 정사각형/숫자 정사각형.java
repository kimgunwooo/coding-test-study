import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] list = new int[n][m];

        for(int i=0;i<n;i++){
            String[] s = br.readLine().split("");
            for(int j=0;j<m;j++){
                list[i][j] = Integer.parseInt(s[j]);
            }
        }
        int min = Math.min(n,m);
        while(min>1){
            for(int i=0;i<=n-min;i++){
                for(int j=0;j<=m-min;j++){
                    int num = list[i][j];
                    if(num==list[i][j+min-1]&&num==list[i+min-1][j]&&num==list[i+min-1][j+min-1]){
                        System.out.println(min*min);
                        return;
                    }
                }
            }
            min--;
        }
        System.out.println(min*min);



    }

}