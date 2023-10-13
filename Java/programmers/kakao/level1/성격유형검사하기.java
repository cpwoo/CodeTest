package CodeTest.Java.programmers.kakao.level1;

import java.util.*;

public class 성격유형검사하기 {
    public String solution(String[] survey, int[] choices) {
        int n = choices.length;
        String[] mbti = new String[]{"R","T","C","F","J","M","A","N"};
        HashMap<String, Integer> score = new HashMap<>();
        
        for (String m : mbti) {
            score.put(m, 0);
        }

        for (int i=0; i<n; i++) {
            String p = survey[i].substring(0, 1);
            String q = survey[i].substring(1, 2);
            if (choices[i] < 4) {
                score.put(p, score.get(p)+4-choices[i]);
            } else {
                score.put(q, score.get(q)+choices[i]-4);
            }
        }

        String answer = "";

        for (int i=0; i<8; i+=2) {
            if (score.get(mbti[i]) >= score.get(mbti[i+1])) {
                answer += mbti[i];
            } else {
                answer += mbti[i+1];
            }
        }

        return answer;
    }
}
