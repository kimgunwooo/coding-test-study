import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.StringTokenizer;

/**
 * 100 * 10000
 */


public class Main {
	public static String S;
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringBuilder sb = new StringBuilder();
	public static StringTokenizer st;


	public static void main(String[] args) throws IOException {

		S = br.readLine();

		int oneCount = 0;
		int zeroCount = 0;
		for(int i=0;i<S.length();i++) {
			char temp = S.charAt(i);
			if(temp == '1') oneCount++;
			else zeroCount++;
		}

		int one = oneCount/2;
		int zero = zeroCount/2;

		sb = new StringBuilder(S);
		int i=0;
		while(one > 0) {
			if(sb.charAt(i) == '1') {
				sb.setCharAt(i, 'X');
				one--;
			}
			i++;
		}

		int j=sb.length() - 1;
		while(zero > 0) {
			if(sb.charAt(j) == '0') {
				sb.setCharAt(j,'X');
				zero--;
			}
			j--;
		}

		for(int k=0;k<sb.length();k++) {
			if(sb.charAt(k) != 'X')
				System.out.print(sb.charAt(k));
		}
	}
}