package CodeTest.Java.programmers.etc.level2;

import java.util.*;

public class 귤고르기 {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for (int t : tangerine) {
            map.put(t, map.getOrDefault(t, 0)+1);
        }
        
        List<Integer> cnt = new ArrayList<>(map.keySet());
        cnt.sort((o1,o2) -> {return map.get(o2)-map.get(o1);});
        
        for (int c : cnt) {
            k -= map.get(c);
            answer++;
            if (k <= 0) break;
        }
        
        return answer;
    }
}
