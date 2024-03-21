import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * ISTJ, ISFJ, INFJ, INTJ, ISTP, ISFP, INFP, INTP, ESTP, ESFP, ENFP, ENTP, ESTJ, ESFJ, ENFJ, ENTJ
 *
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for(int i=0;i<n;i++) {
            int x = Integer.parseInt(br.readLine());

            String[] mbti = new String[x];
            StringTokenizer st = new StringTokenizer(br.readLine()," ");

            if(x > 32) {
                System.out.println(0);
                continue;
            }

            for(int j=0;j<x;j++) {
                String str = st.nextToken();
                mbti[j] = str;
            }


            int result = 0;
            int min = Integer.MAX_VALUE;
            for(int k=0;k<x-2;k++){
                for(int l=k+1;l<x-1;l++){
                    for(int m=l+1;m<x;m++){
                        int a = diff(mbti[k], mbti[l]);
                        int b = diff(mbti[l], mbti[m]);
                        int c = diff(mbti[m], mbti[k]);

                        min = Math.min(min, a+b+c);

                    }
                }
                result = min;
            }
            System.out.println(result);
        }


    }

    private static int diff(String key1, String key2) {
        int count = 0;
        for(int i=0;i<4;i++) {
            if(key1.charAt(i) != key2.charAt(i))
                count++;
        }
        return count;
    }
}
