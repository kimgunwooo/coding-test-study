import java.io.*;
import java.util.*;
import javax.swing.JInternalFrame;

/**
 * 시간 제한 1초
 * 메모리 제한 128 MB
 * ---
 * N <= 100
 * 1 2 3 4 5 6 7
 * 3 1 1 5 5 4 6
 * 여기서 1, 4, 5 를 뽑아서 두 집합이 일치하게 만들면 됨.
 * 위 아래가 같다면 무조건 선택하고,
 * (1,3) , (3,1) 와 같이 쌍이 같은부분이 있다면 선택
 *
 * 여기서 그래프가 이루어질 수도 있음. 모든 key 에서 그래프 탐색을 이어가면서 순환이 만들어지면 해당 경로를 저장.
 */

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;
    public static int T;

    public static int[] nums;
    public static List<Integer> list = new ArrayList<>();
    public static boolean[] visited;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());

        nums = new int[n+1];
        visited = new boolean[n+1];

        for (int i = 1; i <= n; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 1; i <= n; i++) {
            visited[i] = true;
            dfs(i, i);
            visited[i] = false;
        }

        Collections.sort(list);
        System.out.println(list.size());
        for (int num : list) {
            System.out.println(num);
        }
    }

    private static void dfs(int cur, int target) {
        if (!visited[nums[cur]]) {
            visited[nums[cur]] = true;
            dfs(nums[cur], target);
            visited[nums[cur]] = false;
        }

        if (nums[cur] == target) {
            list.add(target);
        }
    }
}