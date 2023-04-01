import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] A = new int[n][2];
        int[] B = new int[n];

        String s = br.readLine();
        StringTokenizer st = new StringTokenizer(s);

        for(int i=0;i<n;i++){
            A[i][0] = Integer.parseInt(st.nextToken());
            A[i][1] = i;
        }

        sort(A);
        for(int i=0;i<n;i++){
            B[A[i][1]] = i;
        }
        for(int i=0;i<n;i++){
            System.out.print(B[i]+" ");
        }
    }
    private static void sort(int[][] A){
        Arrays.sort(A,(next,current) ->{//반환값이 양수면 현재요소가 다음요소보다 뒤로 정렬
            if(next[0]<current[0]) {
                return -1;
            }
            else if (next[0]>current[0]) {
                return 1;
            }
            else{//동일할 경우
                return 0; //현위치 유지
                //return Integer.compare(next[1],current[1]); //사전식 정렬
            }
        });
    }
}