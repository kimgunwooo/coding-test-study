import java.util.*;

/**
4 > 3
4 > 2
3 > 2
1 > 2
2 > 5

1,3,4 모두 2한테 이김. 4는 3에게 이겼지만, 1의 순위를 모르기에 정확한 순위 모름
2는 4위, 2에게진 5는 5위

1 -> 2 -> 5
2 -> 5
3 -> 2 -> 5
4 -> 3, 2 -> 5
5

1
2 -> 1, 3, 4
3 -> 4
4
5 -> 2 -> 1,3,4
*/

class Solution {
    public int solution(int n, int[][] results) {
        List<List<Integer>> winGraph = new ArrayList<>();
        List<List<Integer>> loseGraph = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            winGraph.add(new ArrayList<>());
            loseGraph.add(new ArrayList<>());
        }

        for (int[] result : results) {
            int winner = result[0];
            int loser = result[1];
            winGraph.get(winner).add(loser);
            loseGraph.get(loser).add(winner);
        }

        int answer = 0;

        for (int i = 1; i <= n; i++) {
            boolean[] visited = new boolean[n + 1];
            int winCount = dfs(i, winGraph, visited);

            visited = new boolean[n + 1];
            int loseCount = dfs(i, loseGraph, visited);

            // 내 위아래에 있는 선수들이 명확하다면 정확한 순위를 파악가능
            if (winCount + loseCount == n - 1) {
                answer++;
            }
        }

        return answer;
    }

    private int dfs(int start, List<List<Integer>> graph, boolean[] visited) {
        visited[start] = true;
        int count = 0;

        for (int next : graph.get(start)) {
            if (!visited[next]) {
                count += 1 + dfs(next, graph, visited);
            }
        }
        return count;
    }
}