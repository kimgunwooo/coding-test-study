import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int result = Solution(n);
        System.out.println(result);
    }

    private static int Solution(int n) {

        int i=0;
        int temp = 1;
        while(true){
            temp += 6*i;
            if(n <= temp)
                return i+1;
            i++;
        }
    }


}
