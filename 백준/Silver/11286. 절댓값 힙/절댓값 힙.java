import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> absHeap = new PriorityQueue<>((o1, o2) -> {
            if(Math.abs(o1) == Math.abs(o2)){
                return o1-o2;
            }
            return Math.abs(o1)-Math.abs(o2);
        });

        for(int i=0;i<n;i++){
            int x = Integer.parseInt(br.readLine());
            if(x!=0){
                absHeap.add(x);
            } else {
                if(absHeap.isEmpty()){
                    sb.append(0).append("\n");
                } else {
                    sb.append(absHeap.remove()).append("\n");
                }
            }
        }

        System.out.println(sb);
    }
}