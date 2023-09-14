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
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Queue<Integer> queue = new LinkedList<>();

        for(int i=1;i<=n;i++)
            queue.add(i);

        sb.append("<");
        while(true){
            for(int i=0;i<k-1;i++){
                int temp = queue.remove();
                queue.add(temp);
            }
            int yose = queue.remove();
            if(queue.isEmpty()){
                sb.append(yose);
                break;
            }
            sb.append(yose+", ");
        }
        sb.append(">");

        System.out.println(sb);
    }
}