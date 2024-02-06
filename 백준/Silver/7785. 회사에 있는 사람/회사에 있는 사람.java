import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        HashMap<String,String> map = new HashMap<>();
        for(int i=0;i<n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            String name = st.nextToken();
            String command = st.nextToken();
            map.put(name,command);
            if(map.get(name).equals("leave"))
                map.remove(name);
        }
        StringBuilder sb = new StringBuilder();
        List<String> list = new ArrayList<>(map.keySet());
        list.sort(Comparator.reverseOrder());

        for(int i=0;i<list.size();i++) {
            sb.append(list.get(i)).append("\n");
        }
        System.out.println(sb);
    }
}
