import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        long[] lan = new long[k];
        for(int i=0;i<k;i++){
            lan[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(lan);
        System.out.println(binarySearch(n,1,lan[k-1],lan));

    }
    public static long binarySearch(int target,long min, long max,long[] lan){
        long result=0;
        long mid=0;
        while(min<=max){
            mid = (min+max)/2;
            long count=0;
            for(long n : lan){
                count+=(n/mid);
            }
            //잘라서 나온 랜선의 개수가 원하는 값보다 작을 때
            //-> 자르는 값을 더 줄여야 함. = mid를 줄여야 함
            if(count<target){
                max = mid - 1;
            }
            else{
                result=mid;
                min = mid + 1;
            }
        }
        return result;
    }
}