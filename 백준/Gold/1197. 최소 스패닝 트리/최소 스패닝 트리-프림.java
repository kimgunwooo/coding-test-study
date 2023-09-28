import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Node implements Comparable<Node>{
    int to;
    int weight;

    public Node(int to, int weight) {
        this.to = to;
        this.weight = weight;
    }

    @Override
    public int compareTo(Node o) {
        return this.weight-o.weight;
    }
}

public class Main {
    static ArrayList<Node>[] list;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        visited = new boolean[v+1];
        list = new ArrayList[v+1];
        for(int i=0;i<=v;i++){
            list[i] = new ArrayList<>();
        }

        for(int i=0;i<e;i++){
            st = new StringTokenizer(br.readLine()," ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            list[from].add(new Node(to,weight));
            list[to].add(new Node(from,weight));
        }

        int result = prim(1);
        System.out.println(result);
    }

    private static int prim(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        int total = 0;
        pq.add(new Node(start,0));

        while(!pq.isEmpty()){
            Node p = pq.remove();
            int node = p.to;
            int weight = p.weight;

            if(visited[node]) continue;

            visited[node] = true;
            total += weight;

            for(Node next : list[node]){
                if(!visited[next.to]){
                    pq.add(next);
                }
            }
        }
        return total;
    }
}
