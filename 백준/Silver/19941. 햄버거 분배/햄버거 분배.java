import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 20000 *
 */

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		char[] bench = new char[n];
		int count = 0;

		String str = br.readLine();
		for(int i=0;i<n;i++) {
			bench[i] = str.charAt(i);
		}

		for(int i=0;i<n;i++) {
			if(bench[i] == 'P') {
				for(int j=i-k;j<=i+k;j++) {
					if(j<0 || j>n-1 || j==i) continue;
					if(bench[j] == 'H') {
						bench[j] = 'X';
						count++;
						break;
					}
				}
			}
		}

		System.out.println(count);
	}
}