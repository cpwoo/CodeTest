package CodeTest.Java.programmers.etc.level1;

import java.util.*;

public class 문자열내림차순으로배치하기 {
    public String solution(String s) {
        String answer = "";
        
        String[] str = s.split("");
        Arrays.sort(str, Collections.reverseOrder());
        
        for (String a : str) {
            answer += a;
        }
        
        return answer;
    }
}
