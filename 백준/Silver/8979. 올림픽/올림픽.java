import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Medal implements Comparable<Medal>{
    int country;
    int gold;
    int silver;
    int bronze;

    public Medal(int country, int gold, int silver, int bronze) {
        this.country = country;
        this.gold = gold;
        this.silver = silver;
        this.bronze = bronze;
    }

    @Override
    public int compareTo(Medal o) {
        if(o.gold == this.gold){
            if(o.silver == this.silver){
                return o.bronze - this.bronze;
            }
            return o.silver - this.silver;
        }
        return o.gold - this.gold;
    }

    @Override
    public String toString() {
        return "Medal{" +
                ", gold=" + gold +
                ", silver=" + silver +
                ", bronze=" + bronze +
                '}';
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        List<Medal> list = new ArrayList<>();
        for(int i=0;i<n;i++) {
            st = new StringTokenizer(br.readLine()," ");
            int country = Integer.parseInt(st.nextToken());
            int gold = Integer.parseInt(st.nextToken());
            int silver = Integer.parseInt(st.nextToken());
            int bronze = Integer.parseInt(st.nextToken());
            list.add(new Medal(country, gold, silver, bronze));
        }

        Collections.sort(list);

        int rank = 1;
        int temp = 1;
        if(list.get(0).country == k){
            System.out.println(1);
            return;
        }
        
        for(int i=1;i<list.size();i++){
            Medal first = list.get(i-1);
            Medal second = list.get(i);

            if(first.gold == second.gold && first.silver == second.silver && first.bronze == second.bronze)
                temp++;
            else {
                rank += temp;
                temp=1;
            }

            if(k == second.country){
                System.out.println(rank);
                break;
            }
        }
    }
}
