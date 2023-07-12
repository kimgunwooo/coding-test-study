import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        long[] router = new long[n];
        for(int i=0;i<n;i++){
            router[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(router);
        System.out.println(binarySearch(
                c,1,router[n-1]-router[0],router));

    }
    public static long binarySearch(int num,long min, long max,long[] router){
        long result=0;
        while(min<=max){
            long count=1;
            long mid = (min+max)/2;
            int m=0;
            for (int i = 0; i < router.length; i++) {
                if (router[i] - router[m] >= mid) {
                    count++;
                    m=i;
                }
            }

            if(count<num){
                max = mid-1;
            }
            else{
                result = mid;
                min = mid + 1;
            }

        }
        return result;
    }
}