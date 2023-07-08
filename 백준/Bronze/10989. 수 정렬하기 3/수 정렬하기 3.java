import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        int[] nums = new int[10001]; //최대 배열

        for(int i=0;i<N;i++){
            nums[Integer.parseInt(br.readLine())]++;
        }

        for(int i=1;i<10001;i++){
            while(nums[i]>0){
                sb.append(i).append('\n');
                nums[i]--;
            }
        }
        System.out.println(sb);
    }
}