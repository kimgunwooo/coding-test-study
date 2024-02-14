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

        String result = Solution(n);
        System.out.println(result);
    }

    private static String Solution(int n) {
        int i=0;
        while(true) {
            if(n-3 >= 3 || n-3 == 0) {
                n-= 3;
            } else {
                n -= 1;
            }

            if(n <= 0) {
                if(i%2 == 0) {
                    return "SK";
                } else {
                    return "CY";
                }
            }

            i++;
        }
    }
}
