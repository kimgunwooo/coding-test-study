import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int result = solution(n);
        System.out.println(result);
    }

    private static int solution(int n) {
        int m = n-100;
        while(m < n) {
            int temp = m;
            int hap = m;
            while(temp!=0){
                hap += temp % 10;
                temp /= 10;
            }
            if(hap == n)
                return m;
            m++;
        }
        return 0;
    }
}
