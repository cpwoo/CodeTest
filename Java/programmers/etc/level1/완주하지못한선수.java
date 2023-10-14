package CodeTest.Java.programmers.etc.level1;

import java.util.*;

public class 완주하지못한선수 {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> hm = new HashMap<>();
        
        for (String player : participant) {
            hm.put(player, hm.getOrDefault(player, 0)+1);
        }
        
        for (String player : completion) {
            hm.put(player, hm.get(player)-1);
        }
        
        for (String key : hm.keySet()) {
            if (hm.get(key) != 0) {
                answer = key;
                break;
            }
        }
        
        return answer;
    }
}
