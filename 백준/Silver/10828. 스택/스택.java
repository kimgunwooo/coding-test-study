import java.io.*;
import java.util.*;

class Main {
    static int[] stack;
    static int size=0; //데이터의 개수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        init(n); //초기화

        StringTokenizer st;
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine()," ");
            String command = st.nextToken();
            switch (command){
                case "push" :
                    int num = Integer.parseInt(st.nextToken());
                    push(num);
                    break;
                case "top" :
                    sb.append(top()).append("\n");
                    break;
                case "size" :
                    sb.append(size).append("\n");
                    break;
                case "pop" :
                    sb.append(pop()).append("\n");
                    break;
                case "empty":
                    sb.append(isEmpty()).append("\n");
                    break;
            }
        }

        System.out.println(sb);
    }
    static void init(int n){
        stack = new int[n];
    }
    static int isEmpty(){
        if(size==0){
            return 1;
        }
        return 0;
    }
    static void push(int num){
        stack[size] = num;
        size++;
    }
    static int top(){
        if(size==0){
            return -1;
        }
        return stack[size-1];
    }
    static int pop(){
        if(size==0){
            return -1;
        }
        int temp = stack[size-1];
        stack[size-1] = 0;
        size--;
        return temp;
    }


}