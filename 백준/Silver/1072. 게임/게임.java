import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static long x,y,z;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        x = Long.parseLong(st.nextToken());
        y = Long.parseLong(st.nextToken());

        z = 100 * y / x;

        if(y==x || z>=99){
            System.out.println(-1);
        }
        else{
            binarySearch(1,x);
        }
    }
    public static void binarySearch(long start, long end){
        long mid=0, ratio=0;
        while(start <= end){
            mid = (start+end)/2;
            ratio = (y+mid)*100 / (x+mid);

            if(ratio>z){
                end = mid - 1;
            } else{
                start = mid + 1;
            }
        }
        System.out.println(start);
    }

}