package CodeTest.Java.programmers.etc.level2;

import java.util.*;

public class 의상 {
    public int solution(String[][] clothes) {
        int answer = 1;
        Map<String, Integer> map = new HashMap<>();
        
        for (String[] c : clothes) {
            map.put(c[1], map.getOrDefault(c[1], 0)+1);
        }

        for (String key : map.keySet()) {
            answer *= map.get(key)+1;
        }

        answer--;
        return answer;
    }
}
