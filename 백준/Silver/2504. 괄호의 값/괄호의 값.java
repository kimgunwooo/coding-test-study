import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(value(br.readLine()));
    }
    static int value(String s){
        Stack<Character> stack = new Stack<>();
        int result=0;
        int temp=1;

        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(c=='('){
                stack.push('(');
                temp *= 2;
            }
            else if(c=='['){
                stack.push('[');
                temp *= 3;
            }
            else if (c==')'){
                if(stack.empty() || stack.peek() != '('){
                    result = 0;
                    break;
                }
                else if(s.charAt(i-1) == '('){
                    result += temp;
                }
                stack.pop();
                temp /= 2;
            }
            else if (c==']'){
                if(stack.empty() || stack.peek() != '['){
                    result = 0;
                    break;
                }
                else if(s.charAt(i-1) == '['){
                    result += temp;
                }
                stack.pop();
                temp /=3;
            }
        }
        if(!stack.empty()){
            return 0;
        }
        return result;
    }
}