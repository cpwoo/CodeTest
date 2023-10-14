package CodeTest.Java.programmers.etc.level1;

import java.util.*;

public class 서울에서김서방찾기 {
    public String solution(String[] seoul) {
        int x = Arrays.asList(seoul).indexOf("Kim");
        return "김서방은 " + x + "에 있다";
    }
}
