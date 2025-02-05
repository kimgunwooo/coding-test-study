import java.io.*;
import java.util.*;

/*
1초, 1024MB
---

---
1 < 문자열 길이 < 1000

*/
public class Main {
    public static int m, n, T;
    public static int[] alphabet = new int[26];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int tc=1; tc<=T; tc++) {
            int N = Integer.parseInt(br.readLine());

            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            for (int i=1; i<=N; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
            }

            sb.append("Material Management ").append(tc).append("\n");
            sb.append("Classification ---- End!").append("\n");
        }
        
        System.out.print(sb);
    }
}