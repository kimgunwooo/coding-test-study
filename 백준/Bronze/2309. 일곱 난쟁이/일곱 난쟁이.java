import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int[] height = new int[9];
        int sum = 0;
        for(int i=0;i<9;i++){
            height[i] = Integer.parseInt(br.readLine());
            sum += height[i];
        }

        for(int i=0;i<height.length-1;i++){
            for(int j=i+1;j<height.length;j++){
                if(sum-height[i]-height[j] == 100){
                    height[i] = 0;
                    height[j] = 0;
                    Arrays.sort(height);
                    for(int k=2;k<height.length;k++){
                        System.out.println(height[k]);
                    }
                    return;
                }
            }
        }

        
    }
}