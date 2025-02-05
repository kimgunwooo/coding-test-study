import java.io.*;
import java.util.*;

/*
2초, 128MB
---
두 개의 영단어가 주어졌을 때, 애너그램 관계에 있도록 제거해야 하는 최소 문자 수.

알파벳 배열을 선언하고, str1에서 각 문자에 해당하는 개수 더하기.
str2를 돌면서 각 문자에 해당하는 개수만큼 빼기
0 : 나오지 않은 문자거나 양쪽 모두에게 동일한 수로 존재하는 문자
1 이상 : str1에게만 존재하므로, str1에서 빼줘야함. 제거 수 증가
-1 이하 : str2에게만 존재하기에, str2에서 빼줘야함. 제거 수 증가
---
1 < 문자열 길이 < 1000

*/
public class Main {
    public static int m, n;
    public static int[] alphabet = new int[26];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String str1 = br.readLine();
        String str2 = br.readLine();

        for (int i=0; i<str1.length(); i++) { // str1의 각 문자 등록
            alphabet[str1.charAt(i) - 'a']++;
        }

        for (int i=0; i<str2.length(); i++) { // str2의 각 문자 등록
            alphabet[str2.charAt(i) - 'a']--;
        }

        int count = 0;
        for (int i=0; i<alphabet.length; i++) {
            if (alphabet[i] != 0) {
                count += Math.abs(alphabet[i]);
            }
        }

        System.out.println(count);
    }
}