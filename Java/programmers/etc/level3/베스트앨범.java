package CodeTest.Java.programmers.etc.level3;

import java.util.*;

public class 베스트앨범 {
    public List<Integer> solution(String[] genres, int[] plays) {
        Map<String, Integer> map = new HashMap<>();
        for (int i=0; i<genres.length; i++) {
            map.put(genres[i], map.getOrDefault(genres[i],0)+plays[i]);
        }
        
        List<String> genre = new ArrayList<>();
        for (String key : map.keySet()) {
            genre.add(key);
        }
        Collections.sort(genre, (o1, o2) -> map.get(o2)-map.get(o1));
        
        List<Integer> answer = new ArrayList<>();
        for (int i=0; i<genre.size(); i++) {
            String g = genre.get(i);
            
            int first = 0;
            int firstIdx = -1;
            for (int j=0; j<genres.length; j++) {
                if (g.equals(genres[j]) && first < plays[j]) {
                    first = plays[j];
                    firstIdx = j;
                }
            }
            
            int second = 0;
            int secondIdx = -1;
            for (int j=0; j<genres.length; j++) {
                if (g.equals(genres[j]) && second < plays[j] && j != firstIdx) {
                    second = plays[j];
                    secondIdx = j;
                }
            }
            answer.add(firstIdx);
            if (secondIdx >= 0) answer.add(secondIdx);
        }
        
        return answer;
    }
}
