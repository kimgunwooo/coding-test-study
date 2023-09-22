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
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for(int i=1;i<=n;i++){
            int x = Integer.parseInt(br.readLine());
            if(minHeap.size() == maxHeap.size()) maxHeap.offer(x);
            else minHeap.offer(x);

            if(!maxHeap.isEmpty() && !minHeap.isEmpty()){
                if(maxHeap.peek() > minHeap.peek()){
                    int temp = maxHeap.remove();
                    maxHeap.add(minHeap.remove());
                    minHeap.add(temp);
                }
            }

            sb.append(maxHeap.peek()).append("\n");
        }

        System.out.println(sb);
    }
}