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

        int result = 0;
        while(true) {
            if(n%5 == 0){
                result += n / 5;
                return result;
            }
            else if(n < 0) {
                return -1;
            }
            n -= 3;
            result++;
        }
    }
}
