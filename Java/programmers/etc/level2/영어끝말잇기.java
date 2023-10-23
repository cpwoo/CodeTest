package CodeTest.Java.programmers.etc.level2;

import java.util.*;

public class 영어끝말잇기 {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        
        Set<String> set = new HashSet<>();
        set.add(words[0]);
        
        for (int i=1; i<words.length; i++) {
            String a = words[i-1], b = words[i];
            if (set.contains(b) || b.length() == 1 || a.charAt(a.length()-1) != b.charAt(0)) {
                answer[0] = i%n + 1; answer[1] = i/n + 1;
                break;
            }
            set.add(b);
        }

        return answer;
    }
}
