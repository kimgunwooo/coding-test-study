import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        String[] arr = new String[N];

        for(int i=0;i<N;i++){
            arr[i] = br.readLine();
        }

        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                //단어 길이가 같다면
                if(o1.length()==o2.length()){
                    return o1.compareTo(o2); //사전순 정렬
                }
                else{
                    return o1.length()-o2.length();
                }
            }
        });

        sb.append(arr[0]).append('\n');
        for(int i=1;i<N;i++){
            if(arr[i].equals(arr[i-1])){
                continue;
            }
            sb.append(arr[i]).append('\n');
        }
        System.out.println(sb);
    }
}