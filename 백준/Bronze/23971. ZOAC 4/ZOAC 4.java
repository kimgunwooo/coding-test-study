import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());


        int result = Solution(h, w, n, m);
        System.out.println(result);
    }

    private static int Solution(int h, int w, int n, int m) {
        int col = (h-1)/(n+1) + 1;
        int row = (w-1)/(m+1) + 1;
        return col * row;
    }

}
