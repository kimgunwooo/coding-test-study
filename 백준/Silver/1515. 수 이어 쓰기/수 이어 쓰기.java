import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 1~n 까지의 숫자를 차례대로 쓰고, 몇 개의 숫자를 지움
 * 나머지에서 나올수있는 n의 최소
 * 쉽게 생각해서 나올 수 있는 최대 수인 30000개 안에서 맞는걸 찾으면됨
 * base 를 기준으로 숫자를 늘려가면서 비교. base 가 2자리가 넘어갈때, 각 자리별로 비교하는게 핵심. ex) 10 -> 1, 0 으로
 *
 */

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();

		int ptr = 0;
		int base = 0;

		while (base++ <= 30000) {
			String temp = String.valueOf(base);
			for (int i = 0; i < temp.length(); i++) {
				if (temp.charAt(i) == str.charAt(ptr)) {
					ptr++;
				}
				if (str.length() == ptr) {
					System.out.println(base);
					return;
				}
			}
		}
	}
}