import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        List<Integer> nums = new ArrayList<Integer>();

        for(int i=0;i<N;i++){
            nums.add(Integer.parseInt(br.readLine()));
        }

        Collections.sort(nums);

        for(int i : nums){
            sb.append(i).append("\n");
        }
        System.out.println(sb);
    }
}