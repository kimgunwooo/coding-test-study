import java.util.HashMap;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<String, Integer> resist = new HashMap<String, Integer>();
        resist.put("black",0);
        resist.put("brown",1);
        resist.put("red",2);
        resist.put("orange",3);
        resist.put("yellow",4);
        resist.put("green",5);
        resist.put("blue",6);
        resist.put("violet",7);
        resist.put("grey",8);
        resist.put("white",9);

        String str1 = sc.next();
        String str2 = sc.next();
        String str3 = sc.next();

        long result = (long) ((resist.get(str1)*10+ resist.get(str2)) * Math.pow(10,resist.get(str3)));
        System.out.println(result);
    }
}