package CodeTest.Java.programmers.etc.level1;

import java.util.*;

public class 문자열내마음대로정렬하기 {
    public String[] solution(String[] strings, int n) {
        Arrays.sort(strings, new Comparator<String>(){
            @Override
            public int compare(String s1, String s2) {
                if (s1.charAt(n) > s2.charAt(n)) return 1;
                else if (s1.charAt(n) == s2.charAt(n)) return s1.compareTo(s2);
                else if (s1.charAt(n) < s2.charAt(n)) return -1;
                else return 0;
            }
        });
        return strings;
  }
}
