import java.util.*;
/*
1. genres 중에 plays 총 합이 큰 순서대로 정렬.
2. 각 genres 안에서 plays 큰 순서대로 정렬
3. 장르별로 가장 많이 재생된 노래 최대 2개까지 모아서 출력 (plays 인덱스 값)
*/

class Play implements Comparable<Play> {
    int idx; // 고유번호
    int play; // 재생횟수
    
    public Play (int idx, int play) {
        this.idx = idx;
        this.play = play;
    }
    
    public int compareTo(Play o) {
        return o.play - this.play;
    }
}

class Genre implements Comparable<Genre> {
    String name; // 장르 이름
    int plays; // 해당 장르의 재생 횟수
    
    public Genre (String name, int plays) {
        this.name = name;
        this.plays = plays;
    }
    
    public int compareTo(Genre o) {
        return o.plays - this.plays;
    }
}

class Solution {
    
    public int[] solution(String[] genres, int[] plays) {
        Map<String, List<Play>> genreMap = new HashMap<>();
        Map<String, Integer> maxMap = new HashMap<>();
        
        for (int i = 0; i < genres.length; i++) {
            genreMap
                .computeIfAbsent(genres[i], g -> new ArrayList<>())
                .add(new Play(i, plays[i]));
            
            maxMap
                .put(genres[i], maxMap.getOrDefault(genres[i], 0) + plays[i]);
        }
        
        List<Genre> genreList = new ArrayList<>();
        for (String key : maxMap.keySet()) {
            genreList.add(new Genre(key, maxMap.get(key)));
        }
        Collections.sort(genreList);
        
        List<Integer> resultList = new ArrayList<>();
        for (Genre g : genreList) {
            List<Play> playList = genreMap.get(g.name);
            Collections.sort(playList);
            
            int len = Math.min(2, playList.size());
            
            for (int i = 0; i < len; i++) {
                resultList.add(playList.get(i).idx);
            }
        }
        
        int[] answer = new int[resultList.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = resultList.get(i);
        }
        
        return answer;
    }
}