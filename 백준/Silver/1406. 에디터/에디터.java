import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static Stack<Character> lStack = new Stack<>();
    static Stack<Character> rStack = new Stack<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        String str = br.readLine();
        for(int i=0;i<str.length();i++) {
            lStack.add(str.charAt(i));
        }

        int m = Integer.parseInt(br.readLine());

        for(int i=0;i<m;i++) {
            String command = br.readLine();
            switch (command.charAt(0)) {
                case 'L' : CursorL(); break;
                case 'D' : CursorD(); break;
                case 'B' : CursorB(); break;
                case 'P' : {
                    CursorP(command.charAt(2));
                    break;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        while(!rStack.isEmpty()){
            sb.append(rStack.pop());
        }
        sb.reverse();
        while(!lStack.isEmpty()){
            sb.append(lStack.pop());
        }
        System.out.println(sb.reverse());
    }

    private static void CursorP(char s) {
        lStack.push(s);
    }

    private static void CursorB() {
        if(lStack.isEmpty())
            return;
        lStack.pop();
    }

    private static void CursorD() {
        if(rStack.isEmpty())
            return;
        char temp = rStack.pop();
        lStack.push(temp);
    }


    private static void CursorL() {
        if(lStack.isEmpty())
            return;
        char temp = lStack.pop();
        rStack.push(temp);
    }
}
