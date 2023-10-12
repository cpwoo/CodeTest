package CodeTest.Java.programmers.kakao.level1;

import java.util.*;

public class 개인정보수집유효기간 {
    public List<Integer> solution(String today, String[] terms, String[] privacies) {
        List<Integer> answer = new ArrayList<>();
        HashMap<String, Integer> termMap = new HashMap<>();

        int date = getDate(today);
        
        for (String term : terms) {
            String[] t = term.split(" ");
            termMap.put(t[0], Integer.parseInt(t[1]));
        }

        for (int i=0; i<privacies.length; i++) {
            String[] privacy = privacies[i].split(" ");
            if (getDate(privacy[0]) + (termMap.get(privacy[1])*28) <= date) {
                answer.add(i+1);
            }
        }
        
        return answer;
    }

    private int getDate(String today) {
        String[] date = today.split("\\.");
        int year = Integer.parseInt(date[0]);
        int month = Integer.parseInt(date[1]);
        int day = Integer.parseInt(date[2]);
        return (year*12*28) + (month*28) + day;
    }
}
