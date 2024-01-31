import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    static int[] origin, sorted;
    static HashMap<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());

        origin = new int[n];
        sorted = new int[n];

        st = new StringTokenizer(br.readLine()," ");
        for(int i=0; i<n; i++) {
            origin[i] = sorted[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(sorted);

        solution();

        StringBuilder sb = new StringBuilder();
        for(int key : origin) {
            int rank = map.get(key);
            sb.append(rank).append(" ");
        }
        System.out.println(sb);
    }


    private static void solution() {
        int rank = 0;
        for(int v : sorted) {
            if(!map.containsKey(v)) {
                map.put(v, rank);
                rank++;
            }
        }
    }
}
