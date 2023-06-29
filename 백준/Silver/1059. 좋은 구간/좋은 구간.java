import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int l = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int[] nums = new int[l];
        for(int i=0;i<l;i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int n = Integer.parseInt(br.readLine());

        Arrays.sort(nums);
        int count = 0;
        boolean check = false;
        for(int i=0;i<l;i++){
            if(nums[i]==n){
                System.out.println(0);
                check=true;
            }
        }
        if(!check){
            if(n<nums[0]){
                count = (n-0)*(nums[0]-n) -1;
            }
            else{
                for(int i=1;i<l;i++){
                    if(nums[i] > n){
                        count = (n-nums[i-1])*(nums[i]-n)-1;
                        break;
                    }
                }
            }
            System.out.println(count);
        }
    }
}
