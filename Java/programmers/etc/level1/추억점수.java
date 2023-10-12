package CodeTest.Java.programmers.etc.level1;

import java.util.*;

public class 추억점수 {
    public List<Integer> solution(String[] name, int[] yearning, String[][] photos) {
        int n = name.length;
        List<Integer> answer = new ArrayList<>();
        HashMap<String, Integer> score = new HashMap<>();
        
        for (int i=0; i<n; i++) {
            score.put(name[i], yearning[i]);
        }

        for (String[] photo : photos) {
            int tmp = 0;
            for (String p : photo) {
                if (score.containsKey(p)) tmp += score.get(p);
            }
            answer.add(tmp);
        }

        return answer;
    }
}
