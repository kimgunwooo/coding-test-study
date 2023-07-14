import java.io.*;
import java.util.*;

class Main {
    static long c;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        c = Long.parseLong(st.nextToken());
        System.out.println(pow(a,b));
    }
    public static long pow(long a, long exp){
        //지수가 1이라면 A^1 그대로 반환
        if(exp==1){
            return a%c;
        }

        //지수의 절반에 해당하는 값 구함
        long temp = pow(a,exp/2);

        //만약 지수가 홀수라면
        if(exp%2==1){
            return ((temp*temp%c) * a) %c;
        }
        //그 외는 짝수이기에 구했던 값을 한 번 더 곱해서 반환
        return temp*temp%c;
    }
}