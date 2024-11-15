import java.util.*;
/*
1 8
2 6
3 3
4 7
5 2
6 5
7 1
8 4

1 - 4 - 7 - 8 - 재방문
2 - 5 - 6
3

1번 상자 수 4 * 2번 상자 수 3 = 12 (최고)
*/

class Solution {
    static boolean[] visited;
    static Map<Integer, Integer> map = new HashMap<>();
    static List<Integer> list = new ArrayList<>();
    
    public int solution(int[] cards) {
        visited = new boolean[cards.length + 1];
        
        for (int i=1; i<=cards.length; i++) {
            map.put(i, cards[i-1]);
        }
        
        for (int i=1; i<=cards.length; i++) {
            dfs(i, 0);
        }
        
        list.sort(Comparator.reverseOrder());
        int x = list.get(0);
        int y = list.get(1);
        
        return x*y;
    }
    
    public void dfs(int v, int depth) {
        if (visited[v]) {
            list.add(depth);
            return;
        }
        
        int start = map.get(v);
        visited[v] = true;
        
        dfs(start, depth + 1);
    }
}