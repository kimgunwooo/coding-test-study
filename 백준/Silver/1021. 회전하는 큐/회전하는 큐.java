import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        LinkedList<Integer> queue = new LinkedList<Integer>();
        for(int i=1;i<=n;i++){
            queue.add(i);
        }

        st = new StringTokenizer(br.readLine()," ");
        int[] num = new int[m];
        for(int i=0;i<m;i++){
            num[i] = Integer.parseInt(st.nextToken());
        }

        int count=0;
        for(int i=0;i<m;i++){
            int target = queue.indexOf(num[i]);
            int half = queue.size()%2==0 ? queue.size()/2-1 : queue.size()/2;

            if(target <= half){
                for(int j=0;j<target;j++){
                    int temp = queue.pollFirst();
                    queue.addLast(temp);
                    count++;
                }
            }
            else{
                for(int j=0;j<queue.size()-target;j++){
                    int temp = queue.pollLast();
                    queue.addFirst(temp);
                    count++;
                }
            }
            queue.pollFirst();
        }
        System.out.println(count);
    }
}