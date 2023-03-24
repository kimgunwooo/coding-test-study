import java.net.Inet4Address;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        for(int i=0;i<k;i++){
            int n = sc.nextInt();
            Fibonacci(n);
        }
    }
    public static void Fibonacci(int n){
        int fn_2=0,fn_1=1,fn, i;
        if(n==0){
            System.out.println("1 0");
        }
        else if(n==1){
            System.out.println("0 1");
        }
        else {
            for (i=2;i<=n;i++){
                fn = fn_1 + fn_2;
                fn_2 = fn_1;
                fn_1 = fn;
            }
            System.out.println(fn_2+" "+fn_1);
        }


    }
}