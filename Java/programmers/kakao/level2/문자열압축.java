package CodeTest.Java.programmers.kakao.level2;

public class 문자열압축 {
    public int solution(String s) {
        int answer = s.length();
        for (int x=1; x<s.length()/2+1; x++) {
            int d = 0;
            String comp = "";
            int c = 1;
            
            for (int i=0; i<s.length(); i+=x) {
                String tmp = "";
                if (i+x <= s.length()) {
                    tmp = s.substring(i, i+x);
                } else {
                    tmp = s.substring(i);
                }
                
                if (comp.equals(tmp)) c++;
                else {
                    d += tmp.length();
                    if (c > 1) {
                        d += String.valueOf(c).length();
                    }
                    c = 1;
                    comp = tmp;
                }
            }
            
            if (c > 1) {
                d += String.valueOf(c).length();
            }
            answer = Math.min(answer, d);
        }
        return answer;
    }
}
