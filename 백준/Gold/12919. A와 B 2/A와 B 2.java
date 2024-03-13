import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static String s;
    static int result = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        s = br.readLine();
        String t = br.readLine();

        solution(t);

        System.out.println(result);
    }

    private static void solution(String t) {
        if(s.length() == t.length()){
            if(s.equals(t))
                result = 1;
            return;
        }

        if(t.endsWith("A")) {
            solution(t.substring(0, t.length()-1));
        }

        if(t.startsWith("B")) {
            StringBuilder sb = new StringBuilder();
            sb.append(t.substring(1));
            String temp = sb.reverse().toString();
            solution(temp);
        }

        return;
    }
}
