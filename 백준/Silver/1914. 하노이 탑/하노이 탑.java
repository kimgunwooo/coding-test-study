import java.io.*;
import java.math.BigInteger;

public class Main {
    public static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BigInteger res = new BigInteger("1"); //
        int n = Integer.parseInt(br.readLine());
        
        if(n<=20) {
            sb.append((int)(Math.pow(2, n) - 1)).append("\n"); //총 이동횟수
            Hanoi(n, 1, 2, 3);
            System.out.println(sb);
        } else { //20보다 큰 경우
            for(int i=0;i<n;i++){
                res = res.multiply(new BigInteger("2"));//2의 n제곱
            }
            res = res.subtract(new BigInteger("1"));//빼기 1
            System.out.println(res);
        }

    }
    public static void Hanoi(int n,int start,int mid,int end) throws IOException{

        //이동할 원판 수가 1개일 때 -> 이동 과정 출력
        if(n==1){
            sb.append(start + " " + end + "\n");
            return;
        }
        //A->C로 n-1개 이동
        //start 지점의 n-1개의 원판을 mid 지점으로 이동
        Hanoi(n-1,start,end,mid);

        //제일 큰 원판을 end 지점으로 이동
        sb.append(start + " " + end + "\n");

        //B->C로 n-1개 이동
        //mid 지점의 n-1개의 원판을 end 지점으로 이동
        Hanoi(n-1,mid,start,end);
    }
}