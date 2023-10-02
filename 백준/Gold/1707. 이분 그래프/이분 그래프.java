import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static List<List<Integer>> graph;
    static int[] colors;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int k = Integer.parseInt(br.readLine());
        for(int i=0;i<k;i++){
            st = new StringTokenizer(br.readLine()," ");
            int v = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            colors = new int[v+1];
            graph = new ArrayList<>();
            for(int j=0;j<=v;j++){
                graph.add(new ArrayList<>());
            }

            for(int j=0;j<e;j++){
                st = new StringTokenizer(br.readLine()," ");
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());

                graph.get(from).add(to);
                graph.get(to).add(from);
            }

            boolean check = false;
            for(int vertex=1;vertex<=v;vertex++){
                if(colors[vertex] == 0){
                    check = BFS(vertex, 1);
                }
                if(!check){
                    break;
                }
            }
            if(check) System.out.println("YES");
            else System.out.println("NO");
        }
    }

    private static boolean BFS(int start, int color) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);

        colors[start] = color;

        while(!queue.isEmpty()) {
            int cur = queue.remove();
            for (int next : graph.get(cur)) {
                if (colors[cur] == colors[next]) {
                    return false;
                }

                if(colors[next] == 0){
                    colors[next] = colors[cur] * -1;
                    queue.add(next);
                }
            }
        }
        return true;
    }
}