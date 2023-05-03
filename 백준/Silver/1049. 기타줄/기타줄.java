import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] pack = new int[m];
        int[] single = new int[m];
        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine()," ");
            pack[i] = Integer.parseInt(st.nextToken());
            single[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(pack);
        Arrays.sort(single);

        int result = 100000;
        result = Math.min((n/6+1)*pack[0],single[0]*n);
        result = Math.min(result,n/6*pack[0]+n%6*single[0]);

        System.out.println(result);
    }

}
