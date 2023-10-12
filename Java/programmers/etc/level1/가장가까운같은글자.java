package CodeTest.Java.programmers.etc.level1;

import java.util.*;

public class 가장가까운같은글자 {
    public List<Integer> solution(String s) {
        List<Integer> answer = new ArrayList<>();
        HashMap<String, Integer> d = new HashMap<>();
        
        String[] st = s.split("");
        for (int idx=0; idx<st.length; idx++) {
            String w = st[idx];
            if (d.containsKey(w)) {
                answer.add(idx-d.get(w));
                d.put(w, idx);
            } else {
                answer.add(-1);
                d.put(w, idx);
            }
        }
        
        return answer;
    }
}
