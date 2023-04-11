import java.io.*;
import java.util.Arrays;
import java.util.Objects;
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        String[] list = new String[n];
        for(int i=0;i<n;i++){
            String[] s = br.readLine().split("");
            list[i] = s[0];
        }
        boolean check = false;
        Arrays.sort(list);
        int count = 1;
        if(n>=5) {
            for (int i = 0; i < n - 1; i++) {
                if (list[i].equals(list[i + 1])) {
                    count++;
                } else {
                    count = 1;
                }
                if (count == 5) {
                    sb.append(list[i]);
                    check = true;
                    count++;
                }
            }
        }


        if(check){
            System.out.println(sb.toString());
        }
        else{
            System.out.println("PREDAJA");
        }
    }
}
