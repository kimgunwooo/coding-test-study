import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 알파벳 26글자
 * 26 * 10 * 100 = 26000
 */

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		String firstWord = br.readLine();

		// init
		int[] alphabets = new int[26];
		for(int i=0;i<firstWord.length();i++) {
			alphabets[firstWord.charAt(i) - 'A']++;
		}

		int result = 0;
		for(int i=0;i<n-1;i++) {
			int[] temp = alphabets.clone();
			int count = 0; // 같은 단어 개수

			String word = br.readLine();
			for(int j=0;j<word.length();j++) {
				if(temp[word.charAt(j) - 'A'] > 0) {
					count++;
					temp[word.charAt(j) - 'A']--;
				}
			}

			// 같은 길이 일 때 == (같은 문자들 or 1개만 다른 문자로 바뀜)
			if(firstWord.length() == word.length() && (word.length() == count || word.length() - 1 == count)) {
				result++;
			}
			// 비교 단어의 길이가 더 길 때 == 비교 단어에서 1개 문자를 제외하곤 다 겹쳐야됨.
			else if(firstWord.length() == word.length() -1 && word.length() - 1 == count) {
				result++;
			}
			// 비교 단어 길이가 더 짧을 때 == 비교 단어에서 든 모든 문자가 겹쳐야됨.
			else if(firstWord.length() == word.length() + 1 && word.length() == count) {
				result++;
			}
		}
		System.out.println(result);
	}
}