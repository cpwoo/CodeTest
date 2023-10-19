package CodeTest.Java.programmers.kakao.level2;

import java.util.*;

public class 튜플 {
    public int[] solution(String s) {
        String[] st = s.replaceAll("[{]", " ")
            .replaceAll("[}]", " ")
            .trim()
            .split(" , ");
        Arrays.sort(st, (o1,o2)->{return o1.length()-o2.length();});
        
        Set<String> visited = new HashSet<>();
        int[] answer = new int[st.length];
        
        int idx = 0;
        for (String i : st) {
            String[] elements = i.split(",");
            for (String e : elements) {
                if (!visited.contains(e)) {
                    visited.add(e);
                    answer[idx++] = Integer.parseInt(e);
                }
            }
        }

        return answer;
    }
}
