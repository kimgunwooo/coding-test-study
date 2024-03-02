import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        
        int n = Integer.parseInt(st.nextToken());
        String game = st.nextToken();
        int playerNum = 0;
        switch (game) {
            case "Y" : playerNum = 2; break;
            case "F" : playerNum = 3; break;
            case "O" : playerNum = 4; break;
        }

        Set<String> playerList = new HashSet<>();
        for(int i=0;i<n;i++){
            String player = br.readLine();
            playerList.add(player);
        }

        System.out.println(playerList.size() / (playerNum-1));
    }
}



