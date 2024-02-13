import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static HashMap<Integer, Integer> map = new HashMap<>();
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for(int i=0;i<n;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            String command = st.nextToken();

            switch (command) {
                case "add" : Add(Integer.parseInt(st.nextToken())); break;
                case "remove" : Remove(Integer.parseInt(st.nextToken())); break;
                case "check" : Check(Integer.parseInt(st.nextToken())); break;
                case "toggle" : Toggle(Integer.parseInt(st.nextToken())); break;
                case "all" : All(); break;
                case "empty" : Empty(); break;
            }
        }
        System.out.println(sb);
    }

    private static void Empty() {
        map = new HashMap<>();
    }

    private static void All() {
        map = new HashMap<>();
        for(int i=1;i<=20;i++){
            map.put(i,0);
        }
    }

    private static void Toggle(int x) {
        if(map.containsKey(x)){
            map.remove(x);
            return;
        }
        map.put(x,0);
    }

    private static void Check(int x) {
        if(map.containsKey(x)) {
            sb.append("1").append("\n");
            return;
        }
        sb.append("0").append("\n");
    }

    private static void Remove(int x) {
        if(!map.containsKey(x))
            return;
        map.remove(x);
    }

    private static void Add(int x) {
        if(map.containsKey(x))
            return;
        map.put(x,0);
    }
}
