import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int result = bfs(n,k);
        System.out.println(result);
    }

    private static int bfs(int src, int dest) {
        Queue<int[]> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[100_001];
        queue.add(new int[]{src, 0});
        visited[src] = true;

        while(!queue.isEmpty()) {
            int[] next = queue.remove();
            int point = next[0];
            int sec = next[1];

            if(point == dest) { // 만남
                return sec;
            }

            int telPo = point * 2;
            if(telPo < 100_001 && !visited[telPo]){
                queue.add(new int[]{telPo, sec});
                visited[telPo] = true;
            }

            int back = point - 1;
            if(back >= 0 && !visited[back]){
                queue.add(new int[]{back, sec+1});
                visited[back] = true;
            }

            int front = point + 1;
            if(front < 100_001 && !visited[front]){
                queue.add(new int[]{front, sec+1});
                visited[front] = true;
            }
        }
        return 0;
    }
}
