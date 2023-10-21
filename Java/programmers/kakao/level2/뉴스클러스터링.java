package CodeTest.Java.programmers.kakao.level2;

import java.util.*;

public class 뉴스클러스터링 {
    public int solution(String str1, String str2) {
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();

        List<String> a = new ArrayList<>();
        List<String> b = new ArrayList<>();

        for (int i=0; i<str1.length()-1; i++) {
            char ch1 = str1.charAt(i);
            char ch2 = str1.charAt(i+1);
            if ('a' <= ch1 && ch1 <= 'z' && 'a' <= ch2 && ch2 <= 'z') {
                a.add(String.valueOf(ch1)+String.valueOf(ch2));
            }
        }

        for (int i=0; i<str2.length()-1; i++) {
            char ch1 = str2.charAt(i);
            char ch2 = str2.charAt(i+1);
            if ('a' <= ch1 && ch1 <= 'z' && 'a' <= ch2 && ch2 <= 'z') {
                b.add(String.valueOf(ch1)+String.valueOf(ch2));
            }
        }

        List<String> g = new ArrayList<>();
        List<String> h = new ArrayList<>();

        for (String i : a) {
            if (b.remove(i)) g.add(i);
            h.add(i);
        }

        h.addAll(b);

        if (h.size()==0) return 65536;
        
        double tmp = (double) g.size()/ (double) h.size();
        tmp *= 65536;
        return (int) tmp;
    }
}
