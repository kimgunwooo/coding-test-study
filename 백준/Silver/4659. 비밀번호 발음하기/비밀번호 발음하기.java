import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        while(true) {
            String password = br.readLine();

            if(password.equals("end")) break;

            boolean check = checkPassword(password);

            if(check)
                sb.append("<").append(password).append(">").append(" is acceptable.").append("\n");
            else
                sb.append("<").append(password).append(">").append(" is not acceptable.").append("\n");
        }
        System.out.println(sb);
    }

    private static boolean checkPassword(String password) {
        char[] passwordArray = password.toCharArray();

        boolean vowelCheck = false;
        boolean valid = true;
        char prev = ' ';
        int count = 0;

        for(int i=0;i<password.length();i++) {
            char c = password.charAt(i);

            if(!vowelCheck) {
                if(isVowel(c)) {
                    vowelCheck = true;
                }
            }

            if(isVowel(c) == isVowel(prev))
                count++;
            else
                count = 1;

            if(count == 2) {
                if(c == prev) {
                    if(!(c == 'e' || c=='o')) {
                        valid = false;
                        break;
                    }
                }
            }

            if(count == 3) {
                valid = false;
                break;
            }

            prev = c;
        }

        if(!vowelCheck || !valid)
            return false;

        return true;
    }

    private static boolean isVowel(char s) {
        if(s == 'a' || s=='e' || s=='i' || s=='o' || s=='u'){
            return true;
        }
        return false;
    }


}


