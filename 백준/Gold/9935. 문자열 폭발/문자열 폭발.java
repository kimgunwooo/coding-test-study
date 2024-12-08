import java.io.*;
import java.util.*;
import javax.swing.JInternalFrame;

/**
 * 시간 제한 2초
 * 메모리 제한 128 MB
 * ---
 * bomb 에 해당하는 문자열이 존재하면 없애고, 나머지 문자열을 합침.
 * 없을때까지 반복. 만약 모든 문자열이 사라진다면 FRULA 출력
 *
 * 브루트포스 방법이 가능한가? 문자열의 최대 길이는 1,000,000
 *
 * substring을 호출하면 새로운 문자열 객체가 생성되기에 이전 문자는 GC의 대상이 되어 메모리 사용량이 증가함.
 * str = str.substring(0, startIdx) + str.substring(startIdx+bomb.length(), str.length());
 * 이렇게 사용하면 안됨.
 */

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        String str = br.readLine();
        String bomb = br.readLine();

        for (char c : str.toCharArray()) {
            sb.append(c);
            if (sb.length() >= bomb.length() && sb.substring(sb.length()-bomb.length()).equals(bomb)) {
                sb.setLength(sb.length()-bomb.length());
            }
        }

        System.out.println(sb.length() == 0 ? "FRULA" : sb.toString());
    }
}