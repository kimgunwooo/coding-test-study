import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int[] numCard = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for(int i=0;i<n;i++){
            numCard[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(numCard);

        int m = Integer.parseInt(br.readLine());
        int[] checkCard = new int[m];
        st = new StringTokenizer(br.readLine()," ");
        for(int i=0;i<m;i++){
            checkCard[i] = Integer.parseInt(st.nextToken());

            sb.append(binarySearch(checkCard[i],0,n-1,numCard)).append(" ");
        }
        System.out.println(sb);
    }
    public static int binarySearch(int m,int min,int max,int[] arr){
        while(min<=max){
            int mid = (min+max)/2;
            if(arr[mid]==m){
                return 1;
            }
            else if(m<arr[mid]){
                max = mid-1;
            }
            else{
                min = mid+1;
            }
        }
        return 0;
    }
}