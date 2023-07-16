import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        //운동을 선택 -> 맥박 + T
        //최대 맥박 = M
        //최소 맥박 = m = 초기 맥박
        //휴식 선택 -> 맥박 - R
        //운동을 N분 할때 필요한 최소 시간은??
        int now = m;
        int timer = 0;
        int count = 0;
        if((now+T)>M){
            System.out.println(-1);
        }
        else{
            while(count<N){
                timer++;
                if((now+T)<=M){
                    now += T;
                    count++;
                }
                else{
                    now -= R;
                    if(now < m)
                        now=m;
                }
            }
            System.out.println(timer);
        }

    }
}