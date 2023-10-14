package CodeTest.Java.programmers.etc.level1;

import java.util.*;

public class 정수내림차순으로배치하기 {
    public long solution(long n) {
        String[] str = String.valueOf(n).split("");
        Arrays.sort(str);

        String answer = "";
        for (int i=str.length-1; i>=0; i--) {
            answer += str[i];
        }
        
        return Long.parseLong(answer);
    }
}
