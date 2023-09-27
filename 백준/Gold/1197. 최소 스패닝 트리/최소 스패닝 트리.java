import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Node implements Comparable<Node>{
    int from;
    int to;
    int weight;
    public Node(int from, int to, int weight) {
        this.from = from;
        this.to = to;
        this.weight = weight;
    }

    @Override
    public int compareTo(Node o) {
        return this.weight-o.weight;
    }
}
public class Main {
    static int[] parents;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        parents = new int[v+1];
        //자기 자신을 가리키도록 초기화
        for(int i=1;i<=v;i++){
            parents[i] = i;
        }
        
        ArrayList<Node> nodeList = new ArrayList<>();
        for(int i=0;i<e;i++){
            st = new StringTokenizer(br.readLine()," ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            //PriorityQueue를 사용해 weight 비용순 (오름차순)으로 정렬
            nodeList.add(new Node(from,to,weight));
        }
        
        Collections.sort(nodeList);

        int sum = 0;
        int count = 0;
        for(Node n : nodeList){
            if(union(n.from, n.to)){
                sum += n.weight;
                count++;

                if(count==e-1) break;
            }
        }
        System.out.println(sum);
    }

    private static boolean union(int from, int to) {
        int fromRoot = find(from);
        int toRoot = find(to);

        //두 노드가 같은 트리에 속해 있다면
        if(fromRoot==toRoot)
            return false;
        //fromRoot를 toRoot의 부모로 설정해 두 트리를 합침
        else {
            parents[toRoot] = fromRoot;
            return true;
        }
    }

    private static int find(int v) {
        if(parents[v]==v) return v; //해당 노드가 루트노드인지
        else return parents[v] = find(parents[v]);
    }
}