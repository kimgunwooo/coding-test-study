import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        Queue<Integer> queue = new LinkedList<>();

        for(int i=1;i<=n;i++)
            queue.add(i);

        while(true){
            int temp = queue.remove();
            if(queue.isEmpty()){
                sb.append(temp);
                break;
            }
            temp = queue.remove();
            queue.add(temp);
        }

        System.out.println(sb);
    }
}