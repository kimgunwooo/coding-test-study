import java.io.*;
import java.util.StringTokenizer;
import java.util.Scanner;
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String n = br.readLine();
        StringTokenizer st = new StringTokenizer(n);
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        //x, y, w-x, h-y 여기의 최소값 찾기
        if(x<y&&w-x<h-y){
            if(x<w-x)
                System.out.println(x);
            else
                System.out.println(w-x);
        }
        else if(x<y&&h-y<w-x){
            if(x<h-y)
                System.out.println(x);
            else
                System.out.println(h-y);
        }
        else if(y<x&&w-x<h-y){
            if(y<w-x)
                System.out.println(y);
            else
                System.out.println(w-x);
        }
        else{
            if(y<h-y)
                System.out.println(y);
            else
                System.out.println(h-y);
        }
    }
}
