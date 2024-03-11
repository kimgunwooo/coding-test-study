import java.util.*;

class Solution {
    public int[] solution(int[][] edges) {
        
        // 초기화
        int[] in = new int[1_000_001];
        int[] out = new int[1_000_001];
        
        // 각 정점별로 in, out 간선 설정
        for(int[] edge : edges) {
            in[edge[1]]++;
            out[edge[0]]++;
        }
        
        int v = 0;
        int donut = 0;
        int stick = 0;
        int eight = 0;
        for(int i=1;i<=1_000_000;i++) {
            
            // 들어오는 간선의 개수가 0 && 나가는 간선의 개수가 2 이상이면 정점
            if(in[i] == 0 && out[i] >= 2) {
                v = i;
            }
            
            // 나가는거 0 이면 막대
            else if(in[i] >= 1 && out[i] == 0)
                stick++;
            
            // 들어오는거 2 이상, 나가는거 2개
            else if(in[i] >= 2 && out[i] == 2)
                eight++;
        }
        
        donut = out[v] - (stick + eight);
        
        int[] answer = {v,donut,stick,eight};
        
        return answer;
    }
}