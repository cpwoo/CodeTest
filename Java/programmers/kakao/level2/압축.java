package CodeTest.Java.programmers.kakao.level2;

import java.util.*;

public class 압축 {
    public List<Integer> solution(String msg) {
        List<Integer> answer = new ArrayList<>();

        int idx = 1;
        Map<String, Integer> map = new HashMap<>();
        for (char i='A'; i<='Z'; i++) {
            map.put(i+"", idx++);
        }

        int size = msg.length();
        for (int i=0; i<size; i++) {
            int a = 1;
            while (i+a <= size && map.containsKey(msg.substring(i, i+a))) a++;
            
            if (i+a > size) {
                answer.add(map.get(msg.substring(i)));
                break;
            }

            answer.add(map.get(msg.substring(i, i+a-1)));
            map.put(msg.substring(i, i+a), idx++);
            if (a > 1) i += a-2;
        }

        return answer;
    }
}
