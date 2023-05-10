import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        while(true){
            int min = N/L - (L-1)/2;
            int max = N/L + Math.round((float)(L-1)/2);
            int sum = 0;
            if(min<0 || L>100){
                System.out.println(-1);
                return;
            }
            for(int i=min;i<=max;i++)
                sum+=i;
            if(sum==N){
                for(int i=min;i<=max;i++) {
                    System.out.print(i + " ");
                }
                return;
            }
            L++;
        }
    }
}