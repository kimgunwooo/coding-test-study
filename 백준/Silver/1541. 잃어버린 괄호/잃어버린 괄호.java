import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(),"-+", true);

        Queue<Integer> nums = new ArrayDeque<>();
        Queue<String> patterns = new ArrayDeque<>();

        int result = 0;

        while (st.hasMoreTokens()) {
            String token = st.nextToken();
            if(isNumber(token)) {
                nums.add(Integer.valueOf(token));
            } else {
                patterns.add(token);
            }
        }

        while(!patterns.isEmpty()) {
            result += nums.remove();
            if(patterns.remove().equals("-")){
                while(!nums.isEmpty()){
                    result -= nums.remove();
                }
                break;
            }
        }
        if(!nums.isEmpty()){
            result += nums.remove();
        }
        System.out.println(result);
    }

    private static boolean isNumber(String token) {
        try {
            Integer.parseInt(token);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
