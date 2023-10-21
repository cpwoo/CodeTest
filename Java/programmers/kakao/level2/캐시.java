package CodeTest.Java.programmers.kakao.level2;

import java.util.*;

public class 캐시 {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        Map<String, Integer> map = new HashMap<>();

        for (int i=0; i<cities.length; i++) {
            String city = cities[i].toLowerCase();
            if (cacheSize == 0) answer += 5;
            else {
                if (map.containsKey(city)) {
                    map.put(city, i);
                    answer++;
                } else {
                    if (map.keySet().size() == cacheSize) {
                        for (String key : map.keySet()) {
                            if (map.get(key) == Collections.min(map.values())) {
                                map.remove(key);
                                break;
                            }
                        }
                    }
                    map.put(city, i);
                    answer += 5;
                }
            }
        }
        
        return answer;
    }
}
