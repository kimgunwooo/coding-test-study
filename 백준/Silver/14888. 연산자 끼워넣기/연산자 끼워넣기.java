import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int MAX = Integer.MIN_VALUE;
    static int MIN = Integer.MAX_VALUE;
    static int[] nums;
    static int[] op = new int[4];
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        nums = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for(int i=0;i<n;i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine()," ");
        for(int i=0;i<4;i++){
            op[i] = Integer.parseInt(st.nextToken());
        }

        dfs(nums[0],1);

        System.out.println(MAX);
        System.out.println(MIN);
    }

    private static void dfs(int num, int idx) {
        if(n==idx){
            MAX = Math.max(num,MAX);
            MIN = Math.min(num,MIN);
            return;
        }
        for(int i=0;i<4;i++){
            if(op[i]>0){
                op[i]--;
                switch(i){
                    case 0: dfs(num + nums[idx],idx+1); break;
                    case 1: dfs(num - nums[idx],idx+1); break;
                    case 2: dfs(num * nums[idx],idx+1); break;
                    case 3: dfs(num / nums[idx],idx+1); break;
                }
                op[i]++;
            }
        }
    }

}