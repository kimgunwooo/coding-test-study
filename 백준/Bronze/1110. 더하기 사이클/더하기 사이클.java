import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        if(n<10)
            n*=10;
        int first = n;
        int count=0;
        while(true){
            int head = n/10;
            int tail = n%10;
            int sum = head+tail;
            if(sum>=10)
                sum-=10;
            n = tail*10 + sum;
            count++;
            if(first==n) {
                System.out.println(count);
                break;
            }
        }

    }

}