import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> brigde = new LinkedList<>();
        
        int brigde_size = 0;
        int time = 0;
        for (int truck : truck_weights) {
            while (true) {
                if (brigde.isEmpty()) { // 다리가 비어있는 경우
                    brigde.offer(truck);
                    brigde_size += truck;
                    time++;
                    break;
                } else if (brigde.size() == bridge_length) { // 다리가 가득 찬 경우
                    brigde_size -= brigde.poll(); // 다리의 맨 앞 트럭 빼기
                } else { // 다리가 가득 차지 않은 경우
                    if (brigde_size + truck <= weight) {
                        brigde.offer(truck);
                        brigde_size += truck;
                        time++;
                        break;
                    } else {
                        brigde.offer(0); // 다음 트럭이 올라올 수 없는 경우 0을 넣어서 앞의 트럭이 건너도록 한다
                        time++;
                    }
                }
            }
        }
        
        return time + bridge_length; // 다리를 건너는 시간도 더해줌
    }
}