import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        
        Map<String,Integer> todayMap = new HashMap<>();
        StringTokenizer st = new StringTokenizer(today,".");
        todayMap.put("year", Integer.parseInt(st.nextToken()));
        todayMap.put("month", Integer.parseInt(st.nextToken()));
        todayMap.put("day", Integer.parseInt(st.nextToken()));
        
        Map<String,Integer> types = new HashMap<>();
        for(int i=0;i<terms.length;i++){
            st = new StringTokenizer(terms[i]," ");
            String type = st.nextToken();
            int deadLine = Integer.parseInt(st.nextToken());
            types.put(type,deadLine);
        }
        
        List<Integer> results = new ArrayList<>();
        for(int i=0;i<privacies.length;i++){
            st = new StringTokenizer(privacies[i],".| ");
            int year = Integer.parseInt(st.nextToken());
            int month = Integer.parseInt(st.nextToken());
            int day = Integer.parseInt(st.nextToken());
            String type = st.nextToken();
            
            month += types.get(type);
            while(month>12){
                year += 1;
                month -= 12;
            }
                
            if(year < todayMap.get("year"))
                results.add(i+1);
            
            else if(year == todayMap.get("year")){
                if(month < todayMap.get("month"))
                    results.add(i+1);
                else if(month == todayMap.get("month"))
                    if(day <= todayMap.get("day"))
                        results.add(i+1);
            }
        }
        
        int[] answer = new int[results.size()];
        for(int i=0;i<results.size();i++)
            answer[i] = results.get(i);
        
        return answer;
    }
}