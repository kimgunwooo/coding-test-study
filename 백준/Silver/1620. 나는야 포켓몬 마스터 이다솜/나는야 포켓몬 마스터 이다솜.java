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

        HashMap<String,String> map = new HashMap<>();
        HashMap<String,String> re_map = new HashMap<>();
        for(int i=1;i<=n;i++){
            String name = br.readLine();
            map.put(name, String.valueOf(i));
            map.put(String.valueOf(i), name);
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<m;i++){
            String question = br.readLine();
            if(map.containsKey(question)){
                sb.append(map.get(question)).append("\n");
            }
            else if(map.containsValue(question)) {
                sb.append(re_map.get(question)).append("\n");
            }
        }

        System.out.println(sb);
    }
}
