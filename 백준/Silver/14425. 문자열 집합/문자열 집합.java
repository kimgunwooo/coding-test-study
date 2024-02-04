import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int result=0;
        HashMap<String, Integer> check = new HashMap<>();
        for(int i=0;i<n;i++) {
            check.put(br.readLine(), i);
        }
        for(int i=0;i<m;i++) {
            String test = br.readLine();
            if(check.containsKey(test)) {
                result++;
            }
        }
        System.out.println(result);
    }
}
