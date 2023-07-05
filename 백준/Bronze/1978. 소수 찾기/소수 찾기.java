import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int count = n;
        for (int i=0;i<n;i++){
            int temp = Integer.parseInt(st.nextToken());
            if(temp==1)
                count--;
            for(int j=2;j<temp;j++){
                if(temp%j==0){
                    count--;
                    break;
                }
            }

        }
        System.out.println(count);


    }
}