import java.util.*;

class Solution {
    
    public static Map<Integer, String> map = new HashMap<>();
    public static Map<Integer, Integer> sum = new HashMap<>();
    
    public int[] solution(int[] fees, String[] records) {        
        for (String record : records) {
            StringTokenizer st = new StringTokenizer(record, " ");
            String time = st.nextToken();
            int carNumber = Integer.parseInt(st.nextToken());
            String status = st.nextToken();
            
            if (map.containsKey(carNumber)) { // 입차 내역이 존재한다면 - 출차 처리
                String inTime = map.get(carNumber);
                timeProcessing(inTime, time, carNumber);
            } else { // 입차 내역이 없다면 - 입차 처리
                map.put(carNumber, time);
            }
        }
        
        for (int number : new ArrayList<>(map.keySet())) { // 출차된 내역이 없는 경우
            System.out.println("출차 된 내역이 없는 번호 : " + number);
            if (map.containsKey(number)) {
                String inTime = map.get(number);
                timeProcessing(inTime, "23:59", number);
            }
        }
        
        Map<Integer, Integer> result = new TreeMap<>();
        for (int number : sum.keySet()) { // 최종 요금 계산
            int time = sum.get(number);
            int fee = time > fees[0] ? fees[1] + (int)Math.ceil((float)(time - fees[0]) / fees[2]) * fees[3] : fees[1];
            result.put(number, fee);
        }
        
        return result.values().stream().mapToInt(i->i).toArray();
    }
    
    // 입차와 출차의 누적 주차 시간을 sum Map에 저장하고, 기존 Map에서 제거하는 메서드
    public void timeProcessing(String inTime, String time, int carNumber) {
        String[] inTimes = inTime.split(":");
        String[] times = time.split(":");

        int hour = Integer.parseInt(times[0]) - Integer.parseInt(inTimes[0]);
        int min = Integer.parseInt(times[1]) - Integer.parseInt(inTimes[1]);
        int parkTime = (60 * hour) + min;
        
        sum.put(carNumber, sum.getOrDefault(carNumber, 0) + parkTime);
        map.remove(carNumber);
    }
}
