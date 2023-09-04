import java.io.*;
import java.util.*;

class Top{
    int num;
    int height;
    public Top(int num, int height) {
        this.num = num;
        this.height = height;
    }
}

class Main {
    static Stack<Top> stack = new Stack<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        StringBuilder sb = new StringBuilder();

        for(int i=1;i<=n;i++){
            int height = Integer.parseInt(st.nextToken());

            if(stack.empty()){
                sb.append(0 + " ");
                stack.push(new Top(i,height));
            } else{
                while(true){
                    if(stack.empty()){
                        sb.append(0 + " ");
                        stack.push(new Top(i,height));
                        break;
                    }
                    Top top = stack.peek();
                    if (top.height > height) {
                        sb.append(top.num + " ");
                        stack.push(new Top(i, height));
                        break;
                    } else {
                        stack.pop();
                    }
                }
            }
        }

        System.out.println(sb);
    }
}