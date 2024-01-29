import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int[] cards;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        cards = new int[n];
        st = new StringTokenizer(br.readLine()," ");
        for(int i=0; i<n; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
        }
        int result = solution();
        System.out.println(result);
    }

    private static int solution() {
        int sum = 0;
        int result = 0;
        for(int i=0;i<n-2;i++){
            for(int j=i+1;j<n-1;j++){
                for(int k=j+1;k<n;k++){
                    sum = cards[i] + cards[j] + cards[k];
                    if (m == sum) {
                        return sum;
                    }
                    if(result < sum && sum < m) {
                        result = sum;
                    }
                }
            }
        }
        return result;
    }
}
