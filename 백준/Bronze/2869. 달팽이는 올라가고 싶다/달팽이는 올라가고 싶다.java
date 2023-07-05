import java.io.*;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        if(A>V){
            bw.write("1");
        }
        else if((V-A)%(A-B)==0){
            bw.write(String.valueOf((V-A)/(A-B)+1));
        }
        else{
            bw.write(String.valueOf((V-A)/(A-B)+2));
        }
        bw.flush();
        bw.close();
    }
}