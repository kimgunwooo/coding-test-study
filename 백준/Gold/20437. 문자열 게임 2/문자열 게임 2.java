import java.io.*;
import java.util.*;

/**
 * 1 ≤ T ≤ 100
 * 1 ≤ K ≤ |W| ≤ 10,000
 * 시간제한 1초, 메모리 1024 MB 메모리를 잘 사용하자
 * O(n^2) 로 brute force 방법은 불가능
 * 알파벳과 해당 위치를 저장해서 26번의 반복만으로 최대랑 최소를 구하면 되지 않을까??
 * 알파벳은 하나에 위치는 여러개가 나올 수 있음.
 * 근데, 그냥
 */

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;
    public static int T;
    public static char[] alphabet = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
    public static Map<Character, List<Integer>> map = new HashMap<>();
    public static int[] counts;

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            String W = br.readLine();
            int K = Integer.parseInt(br.readLine());
            solution(W, K);
        }

        System.out.println(sb);
    }

    private static void init() {
        counts = new int[26];
        map.clear();
        for (char c : alphabet) {
            map.put(c, new ArrayList<>());
        }
    }

    private static void solution(String W, int K) {
        init();
        boolean flag = false;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < W.length(); i++) {
            char key = W.charAt(i);
            map.get(key).add(i);
            counts[key - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            int window = 0;
            if (counts[i] >= K) {
                flag = true;
                int start = 0;
                int end = K-1;
                window = map.get(alphabet[i]).get(end) - map.get(alphabet[i]).get(start) + 1;
                max = Math.max(max, window);
                min = Math.min(min, window);
                for (int j = 0; j < map.get(alphabet[i]).size()-K; j++) {
                    window = map.get(alphabet[i]).get(++end) - map.get(alphabet[i]).get(++start) + 1;
                    max = Math.max(max, window);
                    min = Math.min(min, window);
                }
            }
        }

        if (flag)
            sb.append(min).append(" ").append(max).append("\n");
        else
            sb.append(-1).append("\n");
    }
}