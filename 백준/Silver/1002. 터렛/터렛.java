import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int n = sc.nextInt();

        for(int i=0;i<n;i++) {
            ArrayList<Integer> number = new ArrayList<>();
            for (int j = 0; j < 6; j++) {
                number.add(sc.nextInt());
            }

            double distance = Math.sqrt(Math.pow(number.get(0)-number.get(3),2)
                    + Math.pow(number.get(1)-number.get(4),2));

            if(distance==0){ //중심이 같을 때
                //반지름이 같음 (완전히 겹침)
                if(Objects.equals(number.get(2), number.get(5))) sb.append(-1+"\n");
                //만나지 않음. 원 원
                else sb.append(0+"\n");
            }
            else{ //중심이 다를 때
                //교점 2개
                if(distance > Math.abs(number.get(2)-number.get(5)) && distance < number.get(2)+number.get(5)) {
                    sb.append(2+"\n");
                }
                //교점 1개
                else if(distance == number.get(2)+number.get(5) || distance == Math.abs(number.get(2)-number.get(5)))
                    sb.append(1+"\n");
                //교점 0개
                else sb.append(0+"\n");
            }
        }
        System.out.println(sb);
    }
}
