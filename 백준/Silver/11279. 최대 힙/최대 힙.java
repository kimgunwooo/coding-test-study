import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());

        for(int i=0;i<n;i++){
            int x = Integer.parseInt(br.readLine());
            if(x>0){
                maxHeap.add(x);
            }
            else if(x==0){
                if(maxHeap.isEmpty()){
                    sb.append(0).append("\n");
                }
                else{
                    int max = maxHeap.remove();
                    sb.append(max).append("\n");
                }
            }
        }

        System.out.println(sb);
    }
}