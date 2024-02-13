import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if(a==0 && b==0 && c==0)
                break;

            String result = Solution(a,b,c);
            sb.append(result).append("\n");
        }



        System.out.println(sb);
    }

    private static String Solution(int a, int b, int c) {
        int[] sorted = {a,b,c};
        Arrays.sort(sorted);

        if(sorted[2] >= sorted[0] + sorted[1])
            return "Invalid";

        if(a==b && b==c)
            return "Equilateral";

        else if(a==b || b==c || a==c)
            return "Isosceles";

        else
            return "Scalene";
    }

}
