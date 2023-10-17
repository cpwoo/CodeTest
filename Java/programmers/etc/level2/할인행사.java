package CodeTest.Java.programmers.etc.level2;

import java.util.*;

public class 할인행사 {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        int days = 10;
        
        Map<String, Integer> buy = new HashMap<>();
        for (int i=0; i<number.length; i++) {
            buy.put(want[i], number[i]);
        }
        
        for (int i=0; i<discount.length-days+1; i++) {
            Map<String, Integer> dis = new HashMap<>();
            for (int j=0; j<days; j++) {
                dis.put(discount[i+j], dis.getOrDefault(discount[i+j],0)+1);
            }
            
            boolean flag = true;
            
            for (String key : buy.keySet()) {
                if (buy.get(key) != dis.get(key)) {
                    flag = false;
                    break;
                }
            }
            
            answer += flag ? 1 : 0;
        }
        return answer;
    }
}
