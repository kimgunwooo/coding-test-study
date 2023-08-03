import java.io.*;
import java.util.*;

class Main {
    static String[] stack = new String[50];
    static int size=0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        for(int i=0;i<n;i++){
            sb.append(solve(br.readLine())).append("\n");
        }

        System.out.println(sb);
    }

    private static String solve(String s) {
        Stack<Character> stack = new Stack<>();

        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);

            if(c=='('){
                stack.push(c);
            }
            if(c==')' && stack.empty()) {
                return "NO";
            }
            if(c==')' && !stack.empty()){
                stack.pop();
            }
        }
        if(stack.empty()){
            return "YES";
        }
        if(!stack.empty()){
            return "NO";
        }
        return s;
    }
}