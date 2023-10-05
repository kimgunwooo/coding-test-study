import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static List<List<Integer>> graph;
    static int[] inOut;
    static boolean[] visited;
    static int n;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        inOut = new int[n+1];

        graph = new ArrayList<>();
        for(int i=0;i<=n;i++){
            graph.add(new ArrayList<>());
        }

        String A = br.readLine();
        for(int i=1;i<n+1;i++){
            inOut[i] = Integer.parseInt(String.valueOf(A.charAt(i-1)));
        }

        for(int i=0;i<n-1;i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            graph.get(from).add(to);
            graph.get(to).add(from);
        }

        for(int i=1;i<=n;i++){
            visited = new boolean[n+1]; //각 정점마다 방문 초기화
            //시작이 실내이면
            if(inOut[i]==1) {
                dfs(i);
            }
        }

        System.out.println(count);
    }
    private static void dfs(int start) {
        visited[start] = true;

        for(int v : graph.get(start)){
            //중간에 모두 야외이며 마지막은 실내로 끝나야 함.
            //야외이면 계속 탐색. - 실내이면 count++
            if(!visited[v]){
                if(inOut[v]==0){
                    dfs(v);
                }
                else{
                    count++;
                }
            }
        }
    }
}