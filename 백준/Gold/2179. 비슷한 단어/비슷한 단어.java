import java.io.*;
import java.util.*;

/**
 * 시간 제한 2초
 * 메모리 제한 128 MB
 * ---
 * index 0부터 보이는지 여/부를 체크해서 제일 많이 보이는 빌딩을 선택.
 */

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    public static int N;
    public static String[] words;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());

        words = new String[N];
        for (int i=0; i<N; i++) {
            words[i] = br.readLine();
        }

        int max = Integer.MIN_VALUE;
        int S = -1;
        int T = -1;
        for (int i=0; i<N-1; i++) {
            for (int j=i+1; j<N; j++) {
                int common = findSameWordCount(words[i], words[j]);
                if (common > max) {
                    max = Math.max(common, max);
                    S = i;
                    T = j;
                }
            }
        }

        System.out.println(words[S]);
        System.out.println(words[T]);
    }

    private static int findSameWordCount(String word, String word1) {
        int count = 0;
        int size = Math.min(word.length(), word1.length());

        for (int i=0; i<size; i++) {
            if (word.charAt(i) == word1.charAt(i)) {
                count++;
            } else break;
        }

        return count;
    }
}