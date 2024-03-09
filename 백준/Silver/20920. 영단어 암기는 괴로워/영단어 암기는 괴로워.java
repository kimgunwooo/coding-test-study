import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int n = Integer.parseInt(st.nextToken()); // 단어의 개수
        int m = Integer.parseInt(st.nextToken()); // 외울 단어의 길이

        Map<String, Integer> map = new HashMap<>();
        for(int i=0;i<n;i++) {
            String str = br.readLine();
            if(str.length() < m) continue; // 짧은 단어는 제외
            map.put(str, map.getOrDefault(str,0)+1);
        }

        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());

        list.sort((o1, o2) -> {
            if(o1.getValue() > o2.getValue()) {
                return o2.getValue()-o1.getValue();
            }
            else if (o1.getValue().equals(o2.getValue()) ) {
                if(o1.getKey().length() > o2.getKey().length()) {
                    return o2.getKey().length()-o1.getKey().length();
                }
                else if (o1.getKey().length() == o2.getKey().length()) {
                    return o1.getKey().compareTo(o2.getKey());
                }
            }
            return 1;
        });

        for(Map.Entry<String, Integer> str : list){
            sb.append(str.getKey()).append("\n");
        }
        System.out.println(sb);
    }
}
