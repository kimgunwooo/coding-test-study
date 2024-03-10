import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        int[] visitors = new int[n];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0;i<n;i++) {
            visitors[i] = Integer.parseInt(st.nextToken());
        }

        int sum = 0;
        for(int i=0;i<x;i++)
            sum += visitors[i];

        int max = sum;
        int cnt = 1;
        for(int i=0;i<n-x;i++) {
            // 윈도우 이동
            sum += visitors[i+x];
            sum -= visitors[i];

            if(sum == max) {
                cnt++;
            }

            if(sum > max){
                cnt = 1;
                max = sum;
            }

        }
        if(max == 0) System.out.println("SAD");
        else {
            System.out.println(max);
            System.out.println(cnt);
        }
    }
}
