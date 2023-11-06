package CodeTest.Java.programmers.kakao.level3;

import java.util.*;

public class 보석쇼핑 {
    public int[] solution(String[] gems) {
        int k = new HashSet<>(Arrays.asList(gems)).size();
        
        Map<String, Integer> map = new HashMap<>();
        map.put(gems[0], 1);

        int[] answer = new int[2];
        answer[0] = 1; answer[1] = gems.length;

        int start = 0, end = 0;

        while (start <= end && end < gems.length) {
            if (map.size() == k) {
                if (answer[1]-answer[0] > end-start) {
                    answer[0] = start+1;
                    answer[1] = end+1;
                }
                map.put(gems[start], map.get(gems[start])-1);
                if (map.get(gems[start]) == 0) {
                    map.remove(gems[start]);
                }
                start++;
            } else if (map.size() < k) {
                end++;
                if (end >= gems.length) break;
                map.put(gems[end], map.getOrDefault(gems[end], 0)+1);
            }
        }
        
        return answer;
    }
}
