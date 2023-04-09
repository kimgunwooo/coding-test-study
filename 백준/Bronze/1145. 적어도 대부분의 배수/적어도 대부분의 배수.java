import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        StringTokenizer st = new StringTokenizer(s);
        int[] nums = new int[5];
        for(int i=0;i<5;i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }
        int check=0;
        int result=1;
        while(check<3){
            check=0;
            for(int i=0;i<5;i++) {
                if(result%nums[i]==0)
                    check++;
            }
            result++;
        }
        System.out.println(--result);
    }

}